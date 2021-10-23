package com.github.mpawelek;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ordinary")
public class OrdinaryEvaluationMethod extends EvaluationMethod {

    @Override
    public String evaluate() {
        return "ordinaryEvaluationMethod";
    }
    
}
