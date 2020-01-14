package com.marcdenning.springvalidation;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.util.Map;

@Component
public class SpringValidatorHibernatePropertiesCustomizer implements HibernatePropertiesCustomizer {

    private final Validator validator;

    public SpringValidatorHibernatePropertiesCustomizer(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("javax.persistence.validation.factory", validator);
    }
}
