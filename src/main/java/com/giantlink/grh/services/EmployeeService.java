package com.giantlink.grh.services;

import java.util.List;

import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse add(EmployeeRequest employee) throws AlreadyExistsException;
	
	EmployeeResponse get(Integer id) throws EntityNotFoundException;
	
	EmployeeResponse update(Integer id, EmployeeRequest employee);
	
	List<EmployeeResponse> get();
	
	void delete(Integer id) throws EntityNotFoundException;
}
