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

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.services.DepartementService;

@RestController
@RequestMapping("/api/v1/departement")
public class DepartementController {
	
	@Autowired
	DepartementService departementService;
	
	@GetMapping
	public ResponseEntity<List<DepartementResponse>> get() {
		return new ResponseEntity<List<DepartementResponse>>(departementService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DepartementResponse> add(@RequestBody DepartementRequest departement) throws AlreadyExistsException {
		return new ResponseEntity<DepartementResponse>(departementService.add(departement), HttpStatus.CREATED);
	}
	
	// Find department by ID
	@GetMapping("{id}")
	public ResponseEntity<DepartementResponse> get(@PathVariable Integer id) throws EntityNotFoundException{
		return new ResponseEntity<DepartementResponse>(departementService.get(id), HttpStatus.OK);
	}
	
	// Find department by name
	@GetMapping("{name}")
	public ResponseEntity<DepartementResponse> get(@PathVariable String name) throws EntityNotFoundException{
		return new ResponseEntity<DepartementResponse>(departementService.get(name), HttpStatus.OK);
	}
	
	// Delete department
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws EntityNotFoundException{
		departementService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update department
	@PutMapping("{id}")
	public ResponseEntity<DepartementResponse> update(@PathVariable Integer id, @RequestBody DepartementRequest departement){
		return new ResponseEntity<DepartementResponse>(departementService.update(id, departement),HttpStatus.OK);
	}
}
