package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.mappers.TeamMapper;
import com.giantlink.grh.models.requests.TeamRequest;
import com.giantlink.grh.models.responses.TeamResponse;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.TeamService;

@Service
public class TeamServiceImlp implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public TeamResponse add(TeamRequest team) throws AlreadyExistsException {
		Optional<Team> findbyname = teamRepository.findByName(team.getName());
		
		if(findbyname.isPresent())
			throw new AlreadyExistsException
			(Team.class.getSimpleName(), team.getName() + " Already exist !!");
		
		return TeamMapper.INSTANCE.entityToResponse
				(teamRepository.save(TeamMapper.INSTANCE.requestToEntity(team)));
	} 

	@Override
	public TeamResponse get(Integer id) throws EntityNotFoundException {
		
		Optional<Team> findbyid = teamRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Team Not Found !");
		
		return TeamMapper.INSTANCE.entityToResponse(findbyid.get());
	}

	@Override
	public TeamResponse get(String name) throws EntityNotFoundException {
		
		Optional<Team> findbyname = teamRepository.findByName(name);
		
		if(!findbyname.isPresent())
			throw new EntityNotFoundException("Team Not Found !");
		
		return TeamMapper.INSTANCE.entityToResponse(findbyname.get());
	}

	@Override
	public List<TeamResponse> get() {
		return TeamMapper.INSTANCE.mapResponse(teamRepository.findAll());
	}

	@Override
	public void delete(Integer id) throws EntityNotFoundException {
		Optional<Team> findbyid = teamRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Team Not Found !");
		
		teamRepository.delete(findbyid.get());
	}

	@Override
	public TeamResponse update(Integer id, TeamRequest team2) {
		Team team = teamRepository.findById(id).get();
		
		team.setDepartement(team2.getDepartement());
		team.setName(team2.getName());
		
		return TeamMapper.INSTANCE.entityToResponse
				(teamRepository.save(team));
	}

}
