package com.giantlink.grh.models.requests;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.entities.Job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OccupationRequest {

	@NotNull
	private Date DateOccupation;
	
	@NotNull
	private Boolean isCurrent;
	
	@NotNull
	Employee employee;
	
	@NotNull
	Job job;
	
}
