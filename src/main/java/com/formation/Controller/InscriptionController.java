package com.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.dao.FormationRepository;
import com.formation.entity.Formation;
import com.formation.entity.Participant;

@Controller
public class InscriptionController {

	
    @PostMapping("/inscription")
    @ResponseBody
    public ResponseEntity<?> inscription(@RequestBody Participant participant, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        // Logique de traitement si la validation réussit
        // Enregistrer le participant dans la base de données, etc.

        return new ResponseEntity<>("Inscription réussie", HttpStatus.OK);
    }
   
}
