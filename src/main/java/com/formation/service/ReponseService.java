package com.formation.service;



import com.formation.entity.Reponse;
import com.formation.dao.ReponseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseService {
    @Autowired
    private ReponseRepository reponseRepository;

    public void saveReponse(List<Reponse> reponse) {
         reponseRepository.saveAll(reponse);
    }
}
