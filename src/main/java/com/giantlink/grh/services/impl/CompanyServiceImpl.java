package com.giantlink.grh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giantlink.grh.entities.Company;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.EntityNotFoundException;
import com.giantlink.grh.mappers.CompanyMapper;
import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.models.responses.CompanyResponse;
import com.giantlink.grh.repositories.CompanyRepository;
import com.giantlink.grh.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public CompanyResponse add(CompanyRequest company) throws AlreadyExistsException {
		
		Optional<Company> findByName = companyRepository.findByName(company.getName());
		
		if(findByName.isPresent())
			throw new AlreadyExistsException
			(Company.class.getSimpleName(), company.getName() + " Already exist !!");
		return CompanyMapper.INSTANCE.companyToResponse
				(companyRepository.save(CompanyMapper.INSTANCE.requestToCompany(company)));
	}

	@Override
	public CompanyResponse get(Integer id) throws EntityNotFoundException {
		Optional<Company> findbyid = companyRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Company introuvable !");
		return CompanyMapper.INSTANCE.companyToResponse(findbyid.get());
	}

	@Override
	public List<CompanyResponse> get() {
		return CompanyMapper.INSTANCE.mapResponse(companyRepository.findAll());
	}

	@Override
	public CompanyResponse get(String name) throws EntityNotFoundException {
		Optional<Company> findbyname = companyRepository.findByName(name);
		
		if(!findbyname.isPresent())
			throw new EntityNotFoundException("Company introuvable !");
		
		return CompanyMapper.INSTANCE.companyToResponse(findbyname.get());
	}

	
	@Override
	public void delete(Integer id) throws EntityNotFoundException {
		Optional<Company> findbyid = companyRepository.findById(id);
		
		if(!findbyid.isPresent())
			throw new EntityNotFoundException("Company introuvable !");
		companyRepository.delete(findbyid.get());
	}

	@Override
	public CompanyResponse update(Integer id, CompanyRequest company2) throws EntityNotFoundException {
		Company company = companyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Company not found !"));
		
		company.setAddress(company2.getAddress());
		company.setEmail(company2.getEmail());
		company.setName(company2.getName());
		
		return CompanyMapper.INSTANCE.companyToResponse
				(companyRepository.save(company));
	}

}
