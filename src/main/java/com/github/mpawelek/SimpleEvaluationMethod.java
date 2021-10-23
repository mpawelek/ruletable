package com.github.mpawelek;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("simple")
public class SimpleEvaluationMethod extends EvaluationMethod {

    @Override
    public String evaluate() {
        return "simpleEvaluetionMethod";
    }
    
}
