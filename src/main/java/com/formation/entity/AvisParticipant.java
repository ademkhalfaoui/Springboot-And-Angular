package com.formation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avis_participant")
public class AvisParticipant {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

@OneToOne
@JoinColumn(name = "participant_id", referencedColumnName = "id")
private Utilisateur participant;

@OneToOne
@JoinColumn(name = "Question_id", referencedColumnName = "id")
private Question question;

@Column
private String reponse;

@OneToOne
@JoinColumn(name = "cours_id", referencedColumnName = "id")
private FileInfo cours;



}
