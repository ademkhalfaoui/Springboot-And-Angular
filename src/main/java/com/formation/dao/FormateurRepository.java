package com.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Formateur;


@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {

}
