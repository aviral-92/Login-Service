package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.modal.Company;

@Repository
public interface CompanyRepoitory extends JpaRepository<Company, Long>{

	public Company findByCompanyName(String name);
	
	public boolean existsByCompanyName(String name);
}
