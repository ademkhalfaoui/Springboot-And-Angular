package com.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dao.QuestionRepository;
import com.formation.dao.ReponseRepository;
import com.formation.entity.Formation;
import com.formation.entity.Question;
import com.formation.entity.Reponse;
import com.formation.entity.ReponseParticipant;
import com.formation.service.ReponseParticipantService;
import com.formation.service.ReponseService;

@RequestMapping("api/v5/quiz")
@RestController
@CrossOrigin
public class QuizController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ReponseRepository reponseRepository;
    @Autowired
    private ReponseService reponseService;
    @Autowired
    private ReponseParticipantService reponseParticipantService;
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @PostMapping("/questions")
    public Question ajouterQuestion(@RequestBody Question question) {
        for (Reponse reponse : question.getReponses()) {
            reponse.setQuestion(question);
        }
        return questionRepository.save(question);
    }

    @PutMapping("/questions/{id}")
    public Question editQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question existingQuestion = questionRepository.findById(id).orElseThrow();
        existingQuestion.setQuestionText(question.getQuestionText());
        
        existingQuestion.getReponses().clear();
        for (Reponse reponse : question.getReponses()) {
            reponse.setQuestion(existingQuestion);
            existingQuestion.getReponses().add(reponse);
        }
        
        return questionRepository.save(existingQuestion);
    }
    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }
    @PostMapping("/reponses")
    public ResponseEntity createReponse(@RequestBody List<Reponse> reponse) {
        try {
              reponseService.saveReponse(reponse);
            return new  ResponseEntity<>( HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @GetMapping("/reponses")
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }
    @PostMapping("/addreponseparticipants")
	public void createreponseparticipant( @RequestBody List<ReponseParticipant> reponseParticipants) {
		 reponseParticipantService.saveReponseParticipant(reponseParticipants);
	}
}