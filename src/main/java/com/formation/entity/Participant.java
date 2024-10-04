package com.formation.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name="Participant")
public class Participant {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id ;
	 @Column
	 private String nom ;
	 @Column
	 private String prenom ;
	 @Column
	
	 private Long  num_cin ;
	 @Column
	 private String theme_formation ;
	 @Column
	 private String Horaire ;
	 @Column
	 private String Periode ;
	
	public Participant(long id, String nom, String prenom, long num_cin, String theme_formation, String horaire,
			String periode, List<Formation> formations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.num_cin = num_cin;
		this.theme_formation = theme_formation;
		Horaire = horaire;
		Periode = periode;
		
	}
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Participant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_cin=" + num_cin
				+ ", theme_formation=" + theme_formation + ", Horaire=" + Horaire + ", Periode=" + Periode
				+ ",  ]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getNum_cin() {
		return num_cin;
	}
	public void setNum_cin(long num_cin) {
		this.num_cin = num_cin;
	}
	public String getTheme_formation() {
		return theme_formation;
	}
	public void setTheme_formation(String theme_formation) {
		this.theme_formation = theme_formation;
	}
	public String getHoraire() {
		return Horaire;
	}
	public void setHoraire(String horaire) {
		Horaire = horaire;
	}
	public String getPeriode() {
		return Periode;
	}
	public void setPeriode(String periode) {
		Periode = periode;
	}
	
}
