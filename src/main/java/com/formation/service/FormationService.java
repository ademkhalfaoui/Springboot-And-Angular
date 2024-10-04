package com.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formation.dao.FileInfoRepository;
import com.formation.dao.FormationRepository;
import com.formation.entity.Formation;

@Service
public class FormationService {

	
	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private FileInfoRepository fileInfoRepository;
	public  Formation saveformation(Formation formation) {
		return formationRepository.save(formation);
	}
	
	
	public  Formation updateformation(Formation formation) {
		Formation existingFormation=formationRepository.findById(formation.getNum_action()).orElse(formation);
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
		
		return formationRepository.save(existingFormation);
	}

public String deleteformation(Long num_action) {
	formationRepository.deleteById(num_action);
	return "formation removed by id "+num_action;
 }
public String deletefile(Long id) {
	fileInfoRepository.deleteById(id);
	return "cours  removed by id "+id;
 }
}
