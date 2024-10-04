package com.formation.entity;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity @Data
@Table(name="Formation")
public class Formation implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long num_action ;
    
    @Column
    private long num_salle;
    @Column
    private String Entreprise;
    @Column
    private String theme_formation;
    @Column
    private String Mode_formation;
    @Column
    private String Lieu_formation;
    @Column
    private String Gouvernorat;
    @Column
    private String Periode;
    @Column
    private String Horaire;
    @Column
    private String Credit_Impot;
    @Column
    private String droit_tirage_collectif;
    @Column
    private String droit_tirage_individuel;
	public Formation(long num_action, long num_salle, String entreprise, String theme_formation, String mode_formation,
			String lieu_formation, String gouvernorat, String periode, String horaire, String credit_Impot,
			String droit_tirage_collectif, String droit_tirage_individuel) {
		super();
		this.num_action = num_action;
		this.num_salle = num_salle;
		Entreprise = entreprise;
		this.theme_formation = theme_formation;
		Mode_formation = mode_formation;
		Lieu_formation = lieu_formation;
		Gouvernorat = gouvernorat;
		Periode = periode;
		Horaire = horaire;
		Credit_Impot = credit_Impot;
		this.droit_tirage_collectif = droit_tirage_collectif;
		this.droit_tirage_individuel = droit_tirage_individuel;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getNum_action() {
		return num_action;
	}
	public void setNum_action(long num_action) {
		this.num_action = num_action;
	}
	public long getNum_salle() {
		return num_salle;
	}
	public void setNum_salle(long num_salle) {
		this.num_salle = num_salle;
	}
	public String getEntreprise() {
		return Entreprise;
	}
	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}
	public String getTheme_formation() {
		return theme_formation;
	}
	public void setTheme_formation(String theme_formation) {
		this.theme_formation = theme_formation;
	}
	public String getMode_formation() {
		return Mode_formation;
	}
	public void setMode_formation(String mode_formation) {
		Mode_formation = mode_formation;
	}
	public String getLieu_formation() {
		return Lieu_formation;
	}
	public void setLieu_formation(String lieu_formation) {
		Lieu_formation = lieu_formation;
	}
	public String getGouvernorat() {
		return Gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		Gouvernorat = gouvernorat;
	}
	public String getPeriode() {
		return Periode;
	}
	public void setPeriode(String periode) {
		Periode = periode;
	}
	public String getHoraire() {
		return Horaire;
	}
	public void setHoraire(String horaire) {
		Horaire = horaire;
	}
	public String getCredit_Impot() {
		return Credit_Impot;
	}
	public void setCredit_Impot(String credit_Impot) {
		Credit_Impot = credit_Impot;
	}
	public String getDroit_tirage_collectif() {
		return droit_tirage_collectif;
	}
	public void setDroit_tirage_collectif(String droit_tirage_collectif) {
		this.droit_tirage_collectif = droit_tirage_collectif;
	}
	public String getDroit_tirage_individuel() {
		return droit_tirage_individuel;
	}
	public void setDroit_tirage_individuel(String droit_tirage_individuel) {
		this.droit_tirage_individuel = droit_tirage_individuel;
	}
	@Override
	public String toString() {
		return "Formation [num_action=" + num_action + ", num_salle=" + num_salle + ", Entreprise=" + Entreprise
				+ ", theme_formation=" + theme_formation + ", Mode_formation=" + Mode_formation + ", Lieu_formation="
				+ Lieu_formation + ", Gouvernorat=" + Gouvernorat + ", Periode=" + Periode + ", Horaire=" + Horaire
				+ ", Credit_Impot=" + Credit_Impot + ", droit_tirage_collectif=" + droit_tirage_collectif
				+ ", droit_tirage_individuel=" + droit_tirage_individuel + "]";
	}
    
    
   @ManyToMany
   public  List<Formateur>  formateurs ;
	
	
	

}
