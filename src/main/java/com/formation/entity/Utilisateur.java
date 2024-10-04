package com.formation.entity;


import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="Utilisateur")
public class Utilisateur  implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public long id ;


@Column
public String nom ;
@Column
public String prenom ;
@Column
public String role;
@Column
@NotNull(message = "Numéro de CIN est obligatoire")
@Pattern(regexp = "^[0-9]{8}$", message = "Numéro de CIN doit contenir 8 chiffres")
public long num_cin;
@Column
@Email(message = "Email doit être valide")
@NotBlank(message = "Email est obligatoire")
public String email;
@Column
public String nom_AR ;
@Column
public String prenom_AR;
@Column

private String  specialite;
@Column
@NotBlank(message = "Direction est obligatoire")
private String direction ;
@Column
private String theme_formation ;
@Column
private String Horaire ;
@Column
private String Periode ;
@Column
private String file ;

private String username;
@Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
private String password;







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

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getNom_AR() {
	return nom_AR;
}

public void setNom_AR(String nom_AR) {
	this.nom_AR = nom_AR;
}

public String getPrenom_AR() {
	return prenom_AR;
}

public void setPrenom_AR(String prenom_AR) {
	this.prenom_AR = prenom_AR;
}

public long getNum_cin() {
	return num_cin;
}

public void setNum_cin(long num_cin) {
	this.num_cin =num_cin;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}

}
