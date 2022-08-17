package com.giantlink.grh.models.responses;

import java.sql.Date;

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
public class OccupationResponse {

	private Integer id;
	
	private Date DateOccupation;
	
	private Boolean isCurrent;
	
	Employee employee;
	
	Job job;
}
