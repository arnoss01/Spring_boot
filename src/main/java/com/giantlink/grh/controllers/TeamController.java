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
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;
import com.giantlink.grh.services.TeamService;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

	@Autowired
	TeamService teamService;
	
	@GetMapping
	public ResponseEntity<List<TeamResponse>> get() {
		return new ResponseEntity<List<TeamResponse>>(teamService.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TeamResponse> add(@RequestBody TeamRequest team) throws AlreadyExistsException {
		return new ResponseEntity<TeamResponse>(teamService.add(team), HttpStatus.CREATED);
	}
	
	// Find team by ID
	@GetMapping("{id}")
	public ResponseEntity<TeamResponse> get(@PathVariable Integer id) throws EntityNotFoundException{
		return new ResponseEntity<TeamResponse>(teamService.get(id), HttpStatus.OK);
	}
	
	// Delete team
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws EntityNotFoundException{
		teamService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	// Update team
	@PutMapping("{id}")
	public ResponseEntity<TeamResponse> update(@PathVariable Integer id, @RequestBody TeamRequest team){
		return new ResponseEntity<TeamResponse>(teamService.update(id, team),HttpStatus.OK);
	}
}
