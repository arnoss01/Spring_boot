package com.giantlink.grh.models.requests;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.giantlink.grh.entities.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartementRequest {

	@NotNull
	@Size(min = 2, max = 50)
	private String name;
	
	@NotNull
	private CompanyEntity companyEntity;
	
	@NotNull
	private Date timestamp;
}
