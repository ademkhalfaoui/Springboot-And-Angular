package com.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{

}
