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

import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;
import com.giantlink.grh.services.OccupationService;

@RestController
@RequestMapping("/api/v1/occupation")
public class OccupationController {

	@Autowired
	OccupationService occupationService;
	
	@GetMapping
	public ResponseEntity<List<OccupationResponse>> get() {
		return new ResponseEntity<List<OccupationResponse>>(occupationService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OccupationResponse> add(@RequestBody OccupationRequest occupation) {
		return new ResponseEntity<OccupationResponse>(occupationService.add(occupation), HttpStatus.CREATED);
	}
	
	// Find occupation by ID
	@GetMapping("{id}")
	public ResponseEntity<OccupationResponse> get(@PathVariable Integer id){
		return new ResponseEntity<OccupationResponse>(occupationService.get(id), HttpStatus.OK);
	}
	
	// Delete occupation
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		occupationService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update occupation
	@PutMapping("{id}")
	public ResponseEntity<OccupationResponse> update(@PathVariable Integer id, @RequestBody OccupationRequest occupation){
		return new ResponseEntity<OccupationResponse>(occupationService.update(id, occupation),HttpStatus.OK);
	}
}
