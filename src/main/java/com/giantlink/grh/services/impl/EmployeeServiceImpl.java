package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.mappers.EmployeeMapper;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;
import com.giantlink.grh.repositories.EmployeeRepository;
import com.giantlink.grh.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeResponse add(EmployeeRequest employee) throws AlreadyExistsException {
		
		Optional<Employee> findbyname = employeeRepository.findByName(employee.getName());
		
		if(!findbyname.isPresent())
			throw new AlreadyExistsException
			(Departement.class.getSimpleName(), 
					employee.getName() + " Already Exist !");
		
		return EmployeeMapper.INSTANCE.entityToResponse
				(employeeRepository.save(EmployeeMapper.INSTANCE.requestToEntity(employee)));
	} 

	@Override
	public EmployeeResponse get(Integer id) throws EntityNotFoundException {
		
		Optional<Employee> findbyid = employeeRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Not Found !");
		
		return EmployeeMapper.INSTANCE.entityToResponse(findbyid.get());
	}

	@Override
	public List<EmployeeResponse> get() {
		return EmployeeMapper.INSTANCE.mapResponse(employeeRepository.findAll());
	}

	@Override
	public void delete(Integer id) throws EntityNotFoundException {
		
		Optional<Employee> findbyid = employeeRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Not Found !");
		
		employeeRepository.delete(findbyid.get());
	}

	@Override
	public EmployeeResponse update(Integer id, EmployeeRequest employee2) {
		Employee employee = employeeRepository.findById(id).get();
		
		employee.setEmail(employee2.getEmail());
		employee.setName(employee2.getName());
		employee.setTeam(employee2.getTeam());
		
		
		return EmployeeMapper.INSTANCE.entityToResponse(employeeRepository.save(employee));
	}

}
