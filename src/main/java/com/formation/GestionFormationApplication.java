package com.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.dao.FormationRepository;
import com.formation.entity.Formation;






@SpringBootApplication
public class GestionFormationApplication implements CommandLineRunner {
	
	@Autowired
	FormationRepository formationRepository;


	public static void main(String[] args) {
		SpringApplication.run(GestionFormationApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("hello formation");

	
	
	}
	

}
