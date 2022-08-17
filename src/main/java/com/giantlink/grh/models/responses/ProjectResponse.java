package com.giantlink.grh.models.responses;

import java.util.Set;

import com.giantlink.grh.entities.Job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

	private Integer id;
	
	private Set<Job> jobs;
}
