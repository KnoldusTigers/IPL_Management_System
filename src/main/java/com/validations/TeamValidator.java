package com.validations;

import com.model.MatchModel;
import com.model.PointModel;
import com.service.resultservice;
import com.validations.MatchValidation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TeamValidator implements ConstraintValidator<MatchValidation, MatchModel> {
    @Autowired
    private resultservice rs;
    public void initialize(MatchValidation constraintAnnotation) {

    }

    public boolean isValid(MatchModel value, ConstraintValidatorContext context) {
        boolean valid = true;

        if (value.getTeam1() == value.getTeam2()) {
            {
                valid = false;
            }
        }


        return valid;
    }


}
