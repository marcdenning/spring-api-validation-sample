package com.marcdenning.springvalidation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/api/people"})
public class PersonController {

    private final Validator validator;

    public PersonController(@Qualifier("myValidator") Validator validator) {
        this.validator = validator;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(
            @Valid @RequestBody Person person,
            BindingResult bindingResult
    ) throws BindException {
        validator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        return ResponseEntity.ok(person);
    }
}
