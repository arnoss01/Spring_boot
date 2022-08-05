package com.giantlink.grh.models.responses;

import com.giantlink.grh.entities.Departement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {

	private Integer id;
	
	private String name;
	
	private Departement departement;
}
