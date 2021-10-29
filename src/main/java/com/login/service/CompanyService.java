package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.login.exception.CustomException;
import com.login.modal.Company;
import com.login.repository.CompanyRepoitory;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepoitory companyRepoitory;

	public Company addCompany(Company company) {
		if (company != null && StringUtils.hasText(company.getCompanyName())) {
			if (!comapanyExistByName(company.getCompanyName()))
				return companyRepoitory.save(company);
			else
				throw new CustomException("Company Name already exist " + company.getCompanyName(), HttpStatus.FOUND);
		} else
			return new Company();
	}

	public List<Company> findAll() {
		return companyRepoitory.findAll();
	}

	public Company findByCompanyName(String companyName) {
		return companyRepoitory.findByCompanyName(companyName);
	}

	public boolean comapanyExistByName(String name) {
		return companyRepoitory.existsByCompanyName(name);
	}
}
