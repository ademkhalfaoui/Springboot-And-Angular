package com.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Reponse;
@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

}
