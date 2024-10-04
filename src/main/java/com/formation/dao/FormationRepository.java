package com.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Formation;
@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

	
}
