package com.giantlink.grh.models.requests;

import java.util.Set;

import com.giantlink.grh.entities.Job;

import lombok.Getter;

@Getter
public class ProjectRequest {

	private Set<Job> jobs;
}
