package com.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}