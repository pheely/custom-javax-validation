package com.bns.project.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=LanguageValidator.class)
@Documented
public @interface Language {
	String message() default "must be valid language. Found: ${validatedValue}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
