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

import com.giantlink.grh.models.requests.ProjectRequest;
import com.giantlink.grh.models.responses.ProjectResponse;
import com.giantlink.grh.services.ProjectService;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<ProjectResponse>> get() {
		return new ResponseEntity<List<ProjectResponse>>(projectService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProjectResponse> add(@RequestBody ProjectRequest project) {
		return new ResponseEntity<ProjectResponse>(projectService.add(project), HttpStatus.CREATED);
	}
	
	// Find project by ID
	@GetMapping("{id}")
	public ResponseEntity<ProjectResponse> get(@PathVariable Integer id){
		return new ResponseEntity<ProjectResponse>(projectService.get(id), HttpStatus.OK);
	}
	
	// Delete project
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		projectService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update project
	@PutMapping("{id}")
	public ResponseEntity<ProjectResponse> update(@PathVariable Integer id, @RequestBody ProjectRequest project){
		return new ResponseEntity<ProjectResponse>(projectService.update(id, project),HttpStatus.OK);
	}
}
