package com.marcdenning.springvalidation;

import jakarta.validation.Validator;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringValidatorHibernatePropertiesCustomizer implements HibernatePropertiesCustomizer {

    private final Validator validator;

    public SpringValidatorHibernatePropertiesCustomizer(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("jakarta.persistence.validation.factory", validator);
    }
}
