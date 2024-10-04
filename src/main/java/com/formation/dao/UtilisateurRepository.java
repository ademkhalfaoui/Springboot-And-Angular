package com.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Utilisateur;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	Optional<Utilisateur> findByUsername(String username);

	

	List<Utilisateur> findByRole(String role);



	void deleteByRole(String role);


	Utilisateur findByIdAndRole(Long id, String role);



	

	

	

	


	
}
