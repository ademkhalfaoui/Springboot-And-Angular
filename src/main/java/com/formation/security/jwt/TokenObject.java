package com.formation.security.jwt;

public class TokenObject {

    private Long id;
    private String username;
    private String role;
    private String nom;
    private String prenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TokenObject(Long id, String username, String role, String nom, String prenom) {
        super();
        this.id = id;
        this.username = username;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TokenObject() {
        super();
        // TODO Auto-generated constructor stub
    }

}
