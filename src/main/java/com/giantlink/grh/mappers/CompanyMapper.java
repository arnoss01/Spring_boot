package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyMapper {

	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	CompanyResponse companyToResponse(Company company);
	
	CompanyResponse map(CompanyRequest companyRequest);
	
	Company requestToCompany(CompanyRequest companyRequest);
	
	List<CompanyResponse> mapResponse(List<Company> companies);
	
}
