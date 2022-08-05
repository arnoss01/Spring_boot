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
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.services.CompanyEntityService;

@RestController
@RequestMapping("/api/v1/company/entity")
public class CompanyEntityController {

	@Autowired
	CompanyEntityService companyEntityService;
	
	@PostMapping
	public ResponseEntity<CompanyEntityResponse> add(@RequestBody CompanyEntityRequest companyEntity) throws AlreadyExistsException{
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.add(companyEntity), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CompanyEntityResponse>> get() throws EntityNotFoundException{
		return new ResponseEntity<List<CompanyEntityResponse>>(companyEntityService.get(),HttpStatus.OK);
	}
	
	// Find companyEntity by ID
	@GetMapping("{id}")
	public ResponseEntity<CompanyEntityResponse> get(@PathVariable Integer id) throws EntityNotFoundException{
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.get(id),HttpStatus.OK);
	}
	
	// Find companyEntity by name
	@GetMapping("{name}")
	public ResponseEntity<CompanyEntityResponse> get(@PathVariable String name) throws EntityNotFoundException{
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.get(name),HttpStatus.OK);
	}
	
	// Delete companyEntity
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws EntityNotFoundException{
		companyEntityService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	// Update companyEntity
	@PutMapping("{id}")
	public ResponseEntity<CompanyEntityResponse> update(@PathVariable Integer id, @RequestBody CompanyEntityRequest companyEntity){
		return new ResponseEntity<CompanyEntityResponse>(companyEntityService.update(id, companyEntity),HttpStatus.OK);
	}
}

