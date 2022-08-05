package com.giantlink.grh.models.responses;

import com.giantlink.grh.entities.Team;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private Team team;
}
