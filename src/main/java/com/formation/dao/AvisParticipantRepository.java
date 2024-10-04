package com.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.AvisParticipant;
@Repository
public interface AvisParticipantRepository extends JpaRepository<AvisParticipant, Long> {

}
