package com.formation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "reponse_participant")
public class ReponseParticipant {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	

	

		@ManyToOne
	    @JoinColumn(name = "utilisateur_id")
	    private Utilisateur utilisateur;
	
	
	  
		@ManyToOne
	    @JoinColumn(name = "reponse_id")
	    private Reponse reponse;
	
	  
		@ManyToOne
	    @JoinColumn(name = "question_id")
	    private Question question;
	
}
	
	
	

