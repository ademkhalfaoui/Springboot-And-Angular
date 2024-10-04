package com.formation.entity;

import java.util.Date;
import java.util.Arrays;

import org.hibernate.engine.jdbc.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@Table(name="File_Info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfo {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id ;
	 @Column
	 private String nom_fichier ;
	 @Column
	 private String nom_formateur;
	
	 @Column
	 private String code_cours ;
	
	
	
	 @Column(name = "File", columnDefinition="LONGBLOB")	    
	 @Lob   
	 private byte[] data;
	 
	 @ManyToOne
	 
	@JoinColumn(name="id_utilisateur")
	 private Utilisateur utilisateur;



	
	 
	 
}