package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.CompanyEntity;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.mappers.CompanyEntityMapper;
import com.giantlink.grh.models.requests.CompanyEntityRequest;
import com.giantlink.grh.models.responses.CompanyEntityResponse;
import com.giantlink.grh.repositories.CompanyEntityRepository;
import com.giantlink.grh.services.CompanyEntityService;

@Service
public class CompanyEntityServiceImpl implements CompanyEntityService {
	@Autowired
	CompanyEntityRepository companyEntityRepository;

	@Override
	public CompanyEntityResponse add(CompanyEntityRequest companyEntity) throws AlreadyExistsException {
		
		Optional<CompanyEntity> findByName = 
				companyEntityRepository.findByName(companyEntity.getName());
		
		if(!findByName.isPresent())
			throw new AlreadyExistsException
			(companyEntity.getClass().getSimpleName(),
					companyEntity.getName() + " Already exist !!");
		 
		return CompanyEntityMapper.INSTANCE.companyEntityToResponse
				(companyEntityRepository.save(CompanyEntityMapper.INSTANCE.
						requestToCompanyEntity(companyEntity)));
	}

	@Override
	public CompanyEntityResponse get(Integer id) throws EntityNotFoundException {
		
		Optional<CompanyEntity> findById = companyEntityRepository.findById(id);
		
		if(!findById.isPresent())
			throw new EntityNotFoundException("CompanyEntity introuvable !");
		
		return CompanyEntityMapper.INSTANCE.companyEntityToResponse(findById.get());
	}

	@Override
	public List<CompanyEntityResponse> get() throws EntityNotFoundException {
		return CompanyEntityMapper.INSTANCE.mapResponse(companyEntityRepository.findAll());
	}

	@Override
	public CompanyEntityResponse get(String name) throws EntityNotFoundException {
		
		Optional<CompanyEntity> findbyname = companyEntityRepository.findByName(name);
		
		if(!findbyname.isPresent())
			throw new EntityNotFoundException("CompanyEntity introuvable !");
		
		return CompanyEntityMapper.INSTANCE.companyEntityToResponse(findbyname.get());
	}

	@Override
	public void delete(Integer id) throws EntityNotFoundException {
		
		Optional<CompanyEntity> findById = companyEntityRepository.findById(id);
		
		if(!findById.isPresent())
			throw new EntityNotFoundException("CompanyEntity introuvable !");
		
		companyEntityRepository.delete(findById.get());
	}

	@Override
	public CompanyEntityResponse update(Integer id, CompanyEntityRequest companyEntity2) {
		CompanyEntity companyEntity = companyEntityRepository.findById(id).get();
		
		companyEntity.setName(companyEntity2.getName());
		companyEntity.setCompany(companyEntity2.getCompany());
		
		companyEntityRepository.save(companyEntity);
		return CompanyEntityMapper.INSTANCE.companyEntityToResponse
				(companyEntityRepository.save(companyEntity));
	}

}
