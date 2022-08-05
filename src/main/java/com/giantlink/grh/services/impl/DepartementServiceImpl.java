package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Departement;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.mappers.DepartementMapper;
import com.giantlink.grh.models.requests.DepartementRequest;
import com.giantlink.grh.models.responses.DepartementResponse;
import com.giantlink.grh.repositories.DepartementRepository;
import com.giantlink.grh.services.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	@Override
	public DepartementResponse add(DepartementRequest departement) throws AlreadyExistsException {
		
		Optional<Departement> findByname = departementRepository.findByName(departement.getName());
		
		if(!findByname.isPresent())
			throw new AlreadyExistsException
			(Departement.class.getSimpleName(), 
					departement.getName() + " Already exist !");
		return DepartementMapper.INSTANCE.entityToResponse
				(departementRepository.save
						(DepartementMapper.INSTANCE.requestToEntity(departement)));
	}

	@Override
	public DepartementResponse get(Integer id) throws EntityNotFoundException {
		
		Optional<Departement> findbyid = departementRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Departement not found");
		
		return DepartementMapper.INSTANCE.entityToResponse(findbyid.get());
	}

	@Override
	public DepartementResponse get(String name) throws EntityNotFoundException {
		
		Optional<Departement> findByname = departementRepository.findByName(name);
		
		if(!findByname.isPresent())
			throw new EntityNotFoundException("Departement not found");
		
		return DepartementMapper.INSTANCE.entityToResponse(findByname.get());
	}

	@Override
	public List<DepartementResponse> get() {
		return DepartementMapper.INSTANCE.mapResponse(departementRepository.findAll());
	}

	@Override
	public void delete(Integer id) throws EntityNotFoundException {

		Optional<Departement> findbyid = departementRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Departement not found");
		
		departementRepository.delete(departementRepository.findById(id).get());
	}

	@Override
	public DepartementResponse update(Integer id, DepartementRequest departement2) {
		Departement departement = departementRepository.findById(id).get();
		
		departement.setCompanyEntity(departement2.getCompanyEntity());
		departement.setName(departement2.getName());
		departement.setTimestamp(departement2.getTimestamp());
		
		return DepartementMapper.INSTANCE.entityToResponse
				(departementRepository.save(departement));
	}

}
