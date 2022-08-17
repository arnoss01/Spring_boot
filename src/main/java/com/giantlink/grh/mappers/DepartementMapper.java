package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepartementMapper {

	DepartementMapper INSTANCE = Mappers.getMapper(DepartementMapper.class);
	
	Departement requestToEntity(DepartementRequest departementRequest);
	
	DepartementResponse entityToResponse(Departement departement);
	
	List<DepartementResponse> mapResponse(List<Departement> departements);
}
