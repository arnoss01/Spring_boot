package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JobMapper {

	JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
	
	Job requestToEnitty(JobRequest jobRequest);
	
	JobResponse entityToResponse(Job job);
	
	List<JobResponse> mapResponse(List<Job> jobs);
}
