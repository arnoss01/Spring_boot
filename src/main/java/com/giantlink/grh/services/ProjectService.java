package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;

public interface ProjectService {

	ProjectResponse add(ProjectRequest project);
	
	ProjectResponse get(Integer id);
	
	ProjectResponse update(Integer id, ProjectRequest project);
	
	List<ProjectResponse> get();
	
	void delete(Integer id);
}
