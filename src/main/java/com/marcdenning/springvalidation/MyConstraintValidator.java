package com.marcdenning.springvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        // Perform any initialization of the instance of the constraint annotation
        // For example, assert that extra parameters are valid
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
        return fieldValue == null || fieldValue.startsWith("Brilliant");
    }
}
