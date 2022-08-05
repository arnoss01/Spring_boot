package com.giantlink.grh.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Project;
import com.giantlink.grh.mappers.ProjectMapper;
import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;
import com.giantlink.grh.repositories.ProjectRepository;
import com.giantlink.grh.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public ProjectResponse add(ProjectRequest project) {
		Project project2 = ProjectMapper.INSTANCE.requestToEntity(project);
		return ProjectMapper.INSTANCE.entityToResponse(project2);
	}

	@Override
	public ProjectResponse get(Integer id) {
		Project project = projectRepository.findById(id).get();
		return ProjectMapper.INSTANCE.entityToResponse(project);
	}

	@Override
	public List<ProjectResponse> get() {
		return ProjectMapper.INSTANCE.mapResponse(projectRepository.findAll());
	}

	@Override
	public void delete(Integer id) {
		projectRepository.delete(projectRepository.findById(id).get());
	}

	@Override
	public ProjectResponse update(Integer id, ProjectRequest project2) {
		Project project = projectRepository.findById(id).get();
		
		project.setJobs(project2.getJobs());
		
		return ProjectMapper.INSTANCE.entityToResponse
				(projectRepository.save(project));
	}

}
