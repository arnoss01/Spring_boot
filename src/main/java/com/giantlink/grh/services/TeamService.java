package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;

public interface TeamService {

	TeamResponse add(TeamRequest team) throws AlreadyExistsException;
	
	TeamResponse get(Integer id) throws EntityNotFoundException;
	
	TeamResponse get(String name) throws EntityNotFoundException;
	
	TeamResponse update(Integer id, TeamRequest team);
	
	List<TeamResponse> get();
	
	void delete(Integer id) throws EntityNotFoundException;
}
