package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;

public interface CompanyEntityService {
	CompanyEntityResponse add(CompanyEntityRequest companyEntity) throws AlreadyExistsException;

	CompanyEntityResponse get(Integer id) throws EntityNotFoundException;
	
	CompanyEntityResponse get(String name) throws EntityNotFoundException;
	
	CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntity);

	List<CompanyEntityResponse> get() throws EntityNotFoundException;
	
	void delete(Integer id) throws EntityNotFoundException;
}
