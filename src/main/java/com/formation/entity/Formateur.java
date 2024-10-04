package com.formation.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Formateur {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nom;
	@Column
	private long num_cin ;
	@Column
	private String  specialite;
	@Column
	private String direction ;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getNum_cin() {
		return num_cin;
	}

	public void setNum_cin(long num_cin) {
		this.num_cin = num_cin;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Formateur(long id, String nom, long num_cin, String specialite, String direction,
			List<Formation> formations) {
		super();
		this.id = id;
		this.nom = nom;
		this.num_cin = num_cin;
		this.specialite = specialite;
		this.direction = direction;
		this.formations = formations;
	}

	@OneToMany
	private List<Formation> formations;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		this.nom =nom;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}


	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
