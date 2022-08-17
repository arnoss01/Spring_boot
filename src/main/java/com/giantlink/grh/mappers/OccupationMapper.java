package com.giantlink.grh.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.giantlink.grh.entities.Occupation;
import com.giantlink.grh.models.requests.OccupationRequest;
import com.giantlink.grh.models.responses.OccupationResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OccupationMapper {

	OccupationMapper INSTANCE = Mappers.getMapper(OccupationMapper.class);
	
	Occupation requestToEntity(OccupationRequest occupationRequest);
	
	OccupationResponse entityToResponse(Occupation occupation);
	
	List<OccupationResponse> mapResponse(List<Occupation> occupations);
}
