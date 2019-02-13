package com.bns.project.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;
	private String phone;
	
	public User(@NotNull String name,
			    @NotNull
			    @Pattern(regexp = "(\\d){3,3}-\\d{3,3}-\\d{4,4}",message = "must match 111-111-1111 format") String phone) {
		this.name = name;
		this.phone = phone;
	}
}
