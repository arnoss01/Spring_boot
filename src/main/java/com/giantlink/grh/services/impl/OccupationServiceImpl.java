package com.giantlink.grh.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.mappers.OccupationMapper;
import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;
import com.giantlink.grh.repositories.OccupationRepository;
import com.giantlink.grh.services.OccupationService;

@Service
public class OccupationServiceImpl implements OccupationService {

	@Autowired
	OccupationRepository occupationRepository;
	
	@Override
	public OccupationResponse add(OccupationRequest occupation) {
		Occupation occupation2 = OccupationMapper.INSTANCE.requestToEntity(occupation);
		return OccupationMapper.INSTANCE.entityToResponse(occupation2);
	}

	@Override
	public OccupationResponse get(Integer id) {
		Occupation occupation = occupationRepository.findById(id).get();
		return OccupationMapper.INSTANCE.entityToResponse(occupation);
	}

	@Override
	public List<OccupationResponse> get() {
		return OccupationMapper.INSTANCE.mapResponse(occupationRepository.findAll());
	}

	@Override
	public void delete(Integer id) {
		occupationRepository.delete(occupationRepository.findById(id).get());
	}

	@Override
	public OccupationResponse update(Integer id, OccupationRequest occupation2) {
		Occupation occupation = occupationRepository.findById(id).get();
		
		occupation.setDateOccupation(occupation2.getDateOccupation());
		occupation.setEmployee(occupation2.getEmployee());
		occupation.setIsCurrent(occupation2.getIsCurrent());
		occupation.setJob(occupation2.getJob());
		
		return OccupationMapper.INSTANCE.
				entityToResponse(occupationRepository.save(occupation));
	}

}
