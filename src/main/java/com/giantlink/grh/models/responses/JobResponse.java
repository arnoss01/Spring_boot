package com.giantlink.grh.models.responses;

import com.giantlink.grh.entities.Project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {

	private Integer id;
	
	private Project project;
}
