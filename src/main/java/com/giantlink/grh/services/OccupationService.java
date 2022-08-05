package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;

public interface OccupationService {

	OccupationResponse add(OccupationRequest occupation);
	
	OccupationResponse get(Integer id);
	
	OccupationResponse update(Integer id, OccupationRequest occupation);
	
	List<OccupationResponse> get();
	
	void delete(Integer id);
}
