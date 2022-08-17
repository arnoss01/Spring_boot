package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyEntityMapper {

	CompanyEntityMapper INSTANCE = Mappers.getMapper(CompanyEntityMapper.class);
	
	CompanyEntity requestToCompanyEntity(CompanyEntityRequest companyEntityRequest);
	
	CompanyEntityResponse companyEntityToResponse(CompanyEntity companyEntity);
	
	List<CompanyEntityResponse> mapResponse(List<CompanyEntity> companyEntities);
}
