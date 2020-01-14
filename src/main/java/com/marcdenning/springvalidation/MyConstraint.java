package com.marcdenning.springvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {MyConstraintValidator.class})
public @interface MyConstraint {

    /**
     * Provide validation failed message. Default resolves to configurable property.
     *
     * @return validation failed message
     */
    String message() default "{MyConstraint}";

    /**
     * Configure constraint groups that can be selected together.
     *
     * @return configured groups
     */
    Class<?>[] groups() default { };

    /**
     * Allow extensibility of the constraint.
     *
     * @return payload object
     */
    Class<? extends Payload>[] payload() default { };
}
