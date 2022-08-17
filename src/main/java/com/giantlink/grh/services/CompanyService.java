package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;

public interface CompanyService {

	CompanyResponse add(CompanyRequest company) throws AlreadyExistsException;

	CompanyResponse get(Integer id) throws EntityNotFoundException;
	
	CompanyResponse get(String name) throws EntityNotFoundException;
	
	CompanyResponse update(Integer id, CompanyRequest company) throws EntityNotFoundException;

	List<CompanyResponse> get();
	
	void delete(Integer id) throws EntityNotFoundException;
}
