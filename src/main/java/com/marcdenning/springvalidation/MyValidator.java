package com.marcdenning.springvalidation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("myValidator")
public class MyValidator implements Validator {

    private String suffix;

    public MyValidator(@Value("${my.validation.person.suffix}") String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Assert.isInstanceOf(
                Person.class,
                target,
                "Argument to MyValidator must be of type Person. Object is of type "
        );
        final Person providedPerson = (Person) target;

        if (providedPerson.getName() != null && !providedPerson.getName().endsWith(suffix)) {
            errors.rejectValue("name", "MyValidator", new Object[] {suffix}, "Incorrect suffix.");
        }
    }
}
