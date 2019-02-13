package com.bns.project.validator;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<Language, String> {

	@Override
	public void initialize(Language constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		
		for (Locale locale : Locale.getAvailableLocales()) {
			if (locale.getDisplayLanguage().equalsIgnoreCase(value))
				return true;
		}
		
		return false;
	}
}
