package com.marcdenning.springvalidation;

import javax.validation.constraints.NotBlank;

public class Person {

    @NotBlank
    @MyConstraint
    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
