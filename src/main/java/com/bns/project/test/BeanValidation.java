package com.bns.project.test;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import com.bns.project.model.MyBean;
import com.bns.project.model.TradeHistory;
import com.bns.project.model.User;

public class BeanValidation {

	public static void main(String[] args) throws NoSuchMethodException {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();

        MyBean bean = new MyBean();
        bean.setLanguage("englis");
        
        Set<ConstraintViolation<MyBean>> violations = validator.validate(bean);
        
        Iterator<ConstraintViolation<MyBean>> it = violations.iterator();
        
        while (it.hasNext()) {
        	System.out.println(it.next().getMessage());
        }
        
        
        // Constructor parameter validation
        
        ExecutableValidator exeValidator = validator.forExecutables();
        

    	Set<ConstraintViolation<User>> userViolations = 
    			exeValidator.validateConstructorParameters(User.class.getConstructor(String.class, String.class), 
    					new Object[] {null, "223-223-222"});
    	
    	for (ConstraintViolation<User> violation : userViolations) {
    		System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
    	}
        
        // Constructor cross parameter validation
        TradeHistory history = new TradeHistory(LocalDate.now(), LocalDate.now().minusDays(5));
        Set<ConstraintViolation<TradeHistory>> historyViolations = 
        		exeValidator.validateConstructorParameters(TradeHistory.class.getConstructor(LocalDate.class, LocalDate.class), 
        				new Object[] {LocalDate.now(), LocalDate.now().minusDays(5)});
        
    	for (ConstraintViolation<TradeHistory> violation : historyViolations) {
    		System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
    	}
        
	}
}

