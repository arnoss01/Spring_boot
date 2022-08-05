package com.giantlink.grh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giantlink.grh.models.requests.CompanyRequest;
import com.giantlink.grh.services.CompanyEntityService;
import com.giantlink.grh.services.CompanyService;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyEntityService companyEntityService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello employee management");
//		CompanyRequest build2 = new CompanyRequest("GIANTLINK","contact@giantlink.fr","FRANCE");
//		CompanyRequest build = new CompanyRequest("GOOGLE","contact@google.fr","USA");
//		companyService.add(build);
//		companyService.add(build2);
		
//		CompanyEntity companyEntity = CompanyEntity.builder().name("Technologie").company(build2).departements(null).build();
//		CompanyEntity companyEntity2 = CompanyEntity.builder().name("Call Centre").company(build2).departements(null).build();
//		CompanyEntity companyEntity3 = CompanyEntity.builder().name("Search").company(build).departements(null).build();
//		
//		companyEntityService.add(companyEntity);
//		companyEntityService.add(companyEntity2);
//		companyEntityService.add(companyEntity3);
		
	}

}
