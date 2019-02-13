package com.bns.project.model;

import javax.validation.constraints.NotNull;

import com.bns.project.validator.Language;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyBean {
	@NotNull
	private String name;
	
	@Language
	private String language;
}
