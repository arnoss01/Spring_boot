package com.giantlink.grh.models.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.giantlink.grh.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntityRequest {
	
	@NotNull
	@Size(min = 2, max = 30)
	private String name;
	
	@NotNull
	private Company company;
}
