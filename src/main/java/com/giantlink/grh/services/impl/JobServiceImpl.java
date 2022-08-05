package com.giantlink.grh.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Job;
import com.giantlink.grh.mappers.JobMapper;
import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;
import com.giantlink.grh.repositories.JobRepository;
import com.giantlink.grh.services.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;
	
	@Override
	public JobResponse add(JobRequest jobRequest) {
		
		Job job = JobMapper.INSTANCE.requestToEnitty(jobRequest);
		return JobMapper.INSTANCE.entityToResponse(job);
	}

	@Override
	public JobResponse get(Integer id) {
		
		Job job = jobRepository.findById(id).get();
		return JobMapper.INSTANCE.entityToResponse(job);
	}

	@Override
	public List<JobResponse> get() {
		return JobMapper.INSTANCE.mapResponse(jobRepository.findAll());
	}

	@Override
	public void delete(Integer id) {
		jobRepository.delete(jobRepository.findById(id).get());
	}

	@Override
	public JobResponse update(Integer id, JobRequest job2) {
		Job job = jobRepository.findById(id).get();
		
		job.setProject(job2.getProject());
		
		return JobMapper.INSTANCE.entityToResponse(jobRepository.save(job));
	}

}
