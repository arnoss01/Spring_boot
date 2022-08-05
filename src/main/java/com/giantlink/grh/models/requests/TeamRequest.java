package com.giantlink.grh.models.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.giantlink.grh.entities.Departement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest {

	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	
	@NotNull
	private Departement departement;
}
