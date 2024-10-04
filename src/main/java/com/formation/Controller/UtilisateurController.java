package com.formation.Controller;

import com.formation.dao.UtilisateurRepository;
import com.formation.entity.Question;
import com.formation.entity.Reponse;
import com.formation.entity.Utilisateur;
import com.formation.security.jwt.JwtProvider;
import com.formation.security.jwt.LoginResponse;
import com.formation.security.jwt.TokenObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    //get all Utilisateur
    @GetMapping("/Utilisateurs")
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    // ajouter nouveaux utilisateurs
    @PostMapping("/adduser")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }
    @GetMapping("/participants")
    public List<Utilisateur> getAllParticipant() {
        return utilisateurRepository.findByRole("participant");
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody Utilisateur utilisateur) {
        try {
            TokenObject tokenObject = new TokenObject();
            Optional<Utilisateur> utilisateurconnected = utilisateurRepository.findByUsername(utilisateur.getUsername());
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getUsername(), utilisateur.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            if (utilisateurconnected.isPresent()) {
                tokenObject.setId(utilisateurconnected.get().getId());
                tokenObject.setUsername(utilisateurconnected.get().getUsername());
                tokenObject.setNom(utilisateurconnected.get().getNom());
                tokenObject.setPrenom(utilisateurconnected.get().getPrenom());
                tokenObject.setRole(utilisateurconnected.get().getRole());
                String jwt = jwtProvider.generateJwtToken(tokenObject);
                return new LoginResponse("200", jwt);
            }
            return new LoginResponse("403", null);

        } catch (Exception e) {
            // TODO: handle exception
            return new LoginResponse("403", null);
        }
    }


    @PutMapping("/participant/{id}")
    public ResponseEntity<Utilisateur> editParticipant(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur existingUtilisateur = utilisateurRepository.findByIdAndRole(id, "participant");
        		
                

        existingUtilisateur.setNom(utilisateur.getNom());
        existingUtilisateur.setPrenom(utilisateur.getPrenom());
        existingUtilisateur.setEmail(utilisateur.getEmail());
        existingUtilisateur.setNom_AR(utilisateur.getNom_AR());
        existingUtilisateur.setPrenom_AR(utilisateur.getPrenom_AR());
        existingUtilisateur.setNum_cin(utilisateur.getNum_cin());
        existingUtilisateur.setDirection(utilisateur.getDirection());
        existingUtilisateur.setSpecialite(utilisateur.getSpecialite());
        existingUtilisateur.setTheme_formation(utilisateur.getTheme_formation());
        existingUtilisateur.setHoraire(utilisateur.getHoraire());
        existingUtilisateur.setPeriode(utilisateur.getPeriode());
        existingUtilisateur.setUsername(utilisateur.getUsername());
        existingUtilisateur.setPassword(utilisateur.getPassword());

        Utilisateur updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }
    
    @GetMapping("/participant/{id}")
    public Utilisateur getParticipant(@PathVariable Long id) {
        return utilisateurRepository.findByIdAndRole(id,"participant");
    }
}
