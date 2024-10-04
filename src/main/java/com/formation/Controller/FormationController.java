package com.formation.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dao.FormationRepository;
import com.formation.entity.Formation;
import com.formation.entity.Utilisateur;
import com.formation.service.FormationService;



@RestController
@CrossOrigin
@RequestMapping( "/api/v1/")
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private FormationService formationService;
	
	//get all formations
	@GetMapping("/formations")
	public List<Formation> getAllFormations(){
		return formationRepository.findAll();
	}

	//create formations rest api
	@PostMapping("/addformations")
	public Formation createFormation( @RequestBody Formation formation) {
		return formationRepository.save(formation);
	}
	@PutMapping("/formation/update/{num_action}")
	public Formation updateFormation(@PathVariable Long num_action, @RequestBody Formation formation) {
		return formationService.updateformation(formation);
	}

	
	  @DeleteMapping("/formation/delete/{num_action}") 
	  public String deleteformation(@PathVariable(value ="num_action" )Long num_action) { return
	  formationService.deleteformation(num_action); }
	 
	  @GetMapping("/formation/{num_action}")
	    public Optional<Formation> getformation(@PathVariable Long num_action) {
	        return formationRepository.findById(num_action);
	    }
	   @PutMapping("/formation/{num_action}")
	    public ResponseEntity<Formation> editParticipant(@PathVariable Long num_action, @RequestBody Formation formation) {
	     Formation existingFormation = formationRepository.findById(formation.getNum_action()).orElse(formation);
	        		
	    	existingFormation.setNum_salle(formation.getNum_salle());
			existingFormation.setLieu_formation(formation.getLieu_formation());
			existingFormation.setMode_formation(formation.getMode_formation());
			existingFormation.setTheme_formation(formation.getTheme_formation());
			existingFormation.setGouvernorat(formation.getGouvernorat());
			existingFormation.setEntreprise(formation.getEntreprise());
			existingFormation.setCredit_Impot(formation.getCredit_Impot());
			existingFormation.setPeriode(formation.getPeriode());
			existingFormation.setHoraire(formation.getHoraire());
			existingFormation.setDroit_tirage_collectif(formation.getDroit_tirage_collectif());
			existingFormation.setDroit_tirage_individuel(formation.getDroit_tirage_individuel());


	        Formation updatedFormation = formationRepository.save(existingFormation);
	        return ResponseEntity.ok(updatedFormation);
	    }
	    



}


