package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.modal.Company;
import com.login.service.CompanyService;

@RequestMapping("/company")
@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/")
	public ResponseEntity<Object> addCompany(@RequestBody Company company) {
		return new ResponseEntity<Object>(companyService.addCompany(company), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<Object>(companyService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getByCompanyName")
	public ResponseEntity<Object> getByCompanyName(@RequestParam String companyName) {
		return new ResponseEntity<Object>(companyService.findByCompanyName(companyName), HttpStatus.OK);
	}
}
