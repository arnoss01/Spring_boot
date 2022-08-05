package com.giantlink.grh.models.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.giantlink.grh.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	@NotNull
	private String name;
	
	@Email(regexp = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$")
	private String email;
	
	private Team team;
}
