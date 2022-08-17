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
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> get() {
		return new ResponseEntity<List<EmployeeResponse>>(employeeService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeResponse> add(@RequestBody EmployeeRequest employee) throws AlreadyExistsException {
		return new ResponseEntity<EmployeeResponse>(employeeService.add(employee), HttpStatus.CREATED);
	}
	
	// Find employee by ID
	@GetMapping("{id}")
	public ResponseEntity<EmployeeResponse> get(@PathVariable Integer id) throws EntityNotFoundException{
		return new ResponseEntity<EmployeeResponse>(employeeService.get(id), HttpStatus.OK);
	}
	
	// Delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws EntityNotFoundException{
		employeeService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update employee
	@PutMapping("{id}")
	public ResponseEntity<EmployeeResponse> update(@PathVariable Integer id, @RequestBody EmployeeRequest employee){
		return new ResponseEntity<EmployeeResponse>(employeeService.update(id, employee),HttpStatus.OK);
	}
}
