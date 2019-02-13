package com.bns.project.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=DateRangeValidator.class)
public @interface DateRangeParams {
    String message () default "'start date' must be less than 'end date'. " +
            "Found: 'start date'=${validatedValue[0]}, " +
            "'end date'=${validatedValue[1]}";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
