package com.formation.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.QuestionRepository;
import com.formation.dao.ReponseParticipantRepository;
import com.formation.dao.ReponseRepository;
import com.formation.dao.UtilisateurRepository;
import com.formation.entity.Question;
import com.formation.entity.Reponse;
import com.formation.entity.ReponseParticipant;
import com.formation.entity.Utilisateur;

@Service 
public class ReponseParticipantService {

	
	@Autowired
	private ReponseParticipantRepository  reponseParticipantRepository;
	
	@Autowired
	private UtilisateurRepository  utilisateurRepository;
	@Autowired
	private ReponseRepository reponseRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
	
	
	public void saveReponseParticipant(List<ReponseParticipant> reponsesParticipants) {
	    if (reponsesParticipants == null || reponsesParticipants.isEmpty()) {
	        throw new IllegalArgumentException("La liste des réponses des participants ne peut pas être nulle ou vide.");
	    }

	    // Récupérer les IDs de tous les utilisateurs, questions et réponses à l'avance
	    List<Long> utilisateurIds = reponsesParticipants.stream()
	            .map(rp -> rp.getUtilisateur().getId())
	            .collect(Collectors.toList());

	    List<Long> questionIds = reponsesParticipants.stream()
	            .map(rp -> rp.getQuestion().getId())
	            .collect(Collectors.toList());

	    List<Long> reponseIds = reponsesParticipants.stream()
	            .map(rp -> rp.getReponse().getId())
	            .collect(Collectors.toList());

	    // Récupérer toutes les entités en une seule fois
	    Map<Long, Utilisateur> utilisateurs = utilisateurRepository.findAllById(utilisateurIds)
	            .stream()
	            .collect(Collectors.toMap(Utilisateur::getId, utilisateur -> utilisateur));

	    Map<Long, Question> questions = questionRepository.findAllById(questionIds)
	            .stream()
	            .collect(Collectors.toMap(Question::getId, question -> question));

	    Map<Long, Reponse> reponses = reponseRepository.findAllById(reponseIds)
	            .stream()
	            .collect(Collectors.toMap(Reponse::getId, reponse -> reponse));

	    reponsesParticipants.forEach(reponseParticipant -> {
	        // Récupérer et définir les entités associées
	        Utilisateur utilisateur = utilisateurs.get(reponseParticipant.getUtilisateur().getId());
	        Question question = questions.get(reponseParticipant.getQuestion().getId());
	        Reponse reponse = reponses.get(reponseParticipant.getReponse().getId());

	        if (utilisateur == null || question == null || reponse == null) {
	            throw new IllegalArgumentException("Une des entités associées n'a pas été trouvée pour ReponseParticipant avec ID: " + reponseParticipant.getId());
	        }

	        reponseParticipant.setUtilisateur(utilisateur);
	        reponseParticipant.setQuestion(question);
	        reponseParticipant.setReponse(reponse);
	    });

	    reponseParticipantRepository.saveAll(reponsesParticipants);
	}
}