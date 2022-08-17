package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;

public interface JobService {

	JobResponse add(JobRequest job);
	
	JobResponse get(Integer id);
	
	JobResponse update(Integer id, JobRequest job);
	
	List<JobResponse> get();
	
	void delete(Integer id);
}
