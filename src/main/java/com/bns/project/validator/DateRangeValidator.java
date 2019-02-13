package com.bns.project.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class DateRangeValidator implements ConstraintValidator<DateRangeParams, Object[]> {
    @Override
    public void initialize(DateRangeParams constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if (value == null || value.length != 2 ||
                            !(value[0] instanceof LocalDate) ||
                            !(value[1] instanceof LocalDate)) {
            return false;
        }

        return ((LocalDate)value[0]).isBefore((LocalDate) value[1]);
    }
}
