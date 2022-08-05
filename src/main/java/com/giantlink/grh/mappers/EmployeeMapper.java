package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.models.requests.EmployeeRequest;
import com.giantlink.grh.models.responses.EmployeeResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {

	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	Employee requestToEntity(EmployeeRequest employeeRequest);
	
	EmployeeResponse entityToResponse(Employee employee);
	
	List<EmployeeResponse> mapResponse(List<Employee> employees);
}
