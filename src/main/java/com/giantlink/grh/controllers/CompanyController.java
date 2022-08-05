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
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.services.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<CompanyResponse>> get() {
		return new ResponseEntity<List<CompanyResponse>>(companyService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CompanyResponse> add(@RequestBody CompanyRequest company) throws AlreadyExistsException {
		System.out.println(company);
		return new ResponseEntity<CompanyResponse>(companyService.add(company), HttpStatus.CREATED);
	}
	
	// Find company by ID
	@GetMapping("{id}")
	public ResponseEntity<CompanyResponse> get(@PathVariable Integer id) throws EntityNotFoundException{
		return new ResponseEntity<CompanyResponse>(companyService.get(id), HttpStatus.OK);
	}
	
	/*
	 * // Find company by name
	 * 
	 * @GetMapping("{name}") public ResponseEntity<Company> get(@PathVariable String
	 * name){ return new ResponseEntity<Company>(companyService.get(name),
	 * HttpStatus.OK); }
	 */
	
	// Delete company
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws EntityNotFoundException{
		companyService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update company
	@PutMapping("{id}")
	public ResponseEntity<CompanyResponse> update(@PathVariable Integer id, @RequestBody CompanyRequest company) throws EntityNotFoundException{
		return new ResponseEntity<CompanyResponse>(companyService.update(id, company),HttpStatus.OK);
	}
}
