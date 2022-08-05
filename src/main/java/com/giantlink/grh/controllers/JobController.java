package com.giantlink.grh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.grh.models.requests.JobRequest;
import com.giantlink.grh.models.responses.JobResponse;
import com.giantlink.grh.services.JobService;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

	@Autowired
	JobService jobService;
	
	@GetMapping
	public ResponseEntity<List<JobResponse>> get() {
		return new ResponseEntity<List<JobResponse>>(jobService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<JobResponse> add(@RequestBody JobRequest job) {
		return new ResponseEntity<JobResponse>(jobService.add(job), HttpStatus.CREATED);
	}
	
	// Find job by ID
	@GetMapping("{id}")
	public ResponseEntity<JobResponse> get(@PathVariable Integer id){
		return new ResponseEntity<JobResponse>(jobService.get(id), HttpStatus.OK);
	}
	
	// Delete job
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		jobService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update job
	@PutMapping("{id}")
	public ResponseEntity<JobResponse> update(@PathVariable Integer id, @RequestBody JobRequest job){
		return new ResponseEntity<JobResponse>(jobService.update(id, job),HttpStatus.OK);
	}
}
