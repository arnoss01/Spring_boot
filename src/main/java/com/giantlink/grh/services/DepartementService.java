package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;

public interface DepartementService {
	DepartementResponse add(DepartementRequest departement) throws AlreadyExistsException;

	DepartementResponse get(Integer id) throws EntityNotFoundException;

	DepartementResponse get(String name) throws EntityNotFoundException;
	
	DepartementResponse update(Integer id, DepartementRequest departement);

	List<DepartementResponse> get();
	
	void delete(Integer id) throws EntityNotFoundException;
}
