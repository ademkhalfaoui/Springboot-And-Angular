package com.formation.validationdeSasie;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.formation.entity.Participant;

public class ParticipantValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Participant.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Participant participant = (Participant) target;
        long numCin = participant.getNum_cin();
        int numDigits = String.valueOf(numCin).length();
        if (numDigits > 8) {
            errors.rejectValue("numCin", "numCin.length", "Le numéro CIN ne doit pas dépasser 8 chiffres");
        }
    }
}
