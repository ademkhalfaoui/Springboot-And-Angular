package com.formation.Controller;
import com.formation.service.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formation.dao.FormateurRepository;
import com.formation.dao.UtilisateurRepository;
import com.formation.entity.Formateur;
import com.formation.entity.Utilisateur;

@RestController
@CrossOrigin
@RequestMapping("/api/v4/")
public class FormateurController {

	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	

	//Get toutes les formteurs 
	@GetMapping("/formateurs")
	public List<Formateur > getAllformateurs(){
		return formateurRepository.findAll();
		}
	//Ajouter des formateurs 
	
	@PostMapping("/addformateur")
	public Formateur AjouterFormateur(@RequestBody Formateur formateur) {
		return formateurRepository.save(formateur);
	}
	
	@GetMapping("/formateurs/{id}")
	public Utilisateur findById(@PathVariable Long  id) {
		return utilisateurRepository.findById(id).get();
	}
	 @PutMapping("/formateurs/{id}")
	    public ResponseEntity<Utilisateur> editParticipant(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
	        Utilisateur existingUtilisateur = utilisateurRepository.findByIdAndRole(id, "formateur");
	        		
	                

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
	@PostMapping("/addformateurs/{id}")
	public Formateur AjouterFormateur(@PathVariable Long id ,@RequestBody Formateur formateur) {
		return formateurRepository.save(formateur);
	}
	
	@GetMapping("/allformateur/{role}")
	public List<Utilisateur> findByRole(@PathVariable String role) {
		return utilisateurRepository.findByRole(role);
	}

    @DeleteMapping("/formateurs/{id}")
    public ResponseEntity<?> deleteFormateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findByIdAndRole(id, "formateur");
        if (utilisateur == null) {
            return new ResponseEntity<>("Utilisateur avec le rôle de formateur non trouvé", HttpStatus.NOT_FOUND);
        }
        utilisateurRepository.delete(utilisateur);
        return new ResponseEntity<>("Utilisateur avec le rôle de formateur supprimé avec succès", HttpStatus.OK);
    }
    @PostMapping(value = "/formateursfile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Utilisateur saveFileintoUtilisateur(@RequestParam MultipartFile file) throws IOException {
    	Path path = Paths.get(System.getProperty("user.dir"), "Utilisateur-app-files");
    	if(!Files.exists(path)) {
    		Files.createDirectories(path);
    	}
    String fileId =UUID.randomUUID().toString();
	Path filePath = Paths.get(System.getProperty("user.dir"), "Utilisateur-app-files",fileId +".pdf");
	Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    Utilisateur utilisateur =Utilisateur.builder()
    		.file(filePath.toUri().toString())
    		.build();
    Utilisateur savedUtilisateur =utilisateurRepository.save(utilisateur);
    return  savedUtilisateur;
    }
    
    @DeleteMapping("/participants/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findByIdAndRole(id, "participant");
        if (utilisateur == null) {
            return new ResponseEntity<>("Utilisateur avec le rôle de participant  non trouvé", HttpStatus.NOT_FOUND);
        }
        utilisateurRepository.delete(utilisateur);
        return new ResponseEntity<>("Utilisateur avec le rôle de participant supprimé avec succès", HttpStatus.OK);
    }
}
