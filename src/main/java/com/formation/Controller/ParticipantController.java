package com.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dao.UtilisateurRepository;
import com.formation.entity.Utilisateur;

@RestController
@CrossOrigin
@RequestMapping( "/api/v3/")
public class ParticipantController {

	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	 @GetMapping("/Participant/{id}")
	    public ResponseEntity<Utilisateur> getParticipantById(@PathVariable Long id) {
	        return utilisateurRepository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }
}
