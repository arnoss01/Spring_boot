package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Project;
import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper {

	ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
	
	Project requestToEntity(ProjectRequest projectRequest);
	
	ProjectResponse entityToResponse(Project project);
	
	List<ProjectResponse> mapResponse(List<Project> projects);
}
