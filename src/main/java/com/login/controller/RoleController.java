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

import com.login.modal.Role;
import com.login.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService RoleService;

	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Object> addRole(@RequestBody Role role) {
		return new ResponseEntity<Object>(RoleService.addRole(role), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<Object> findAll() {
		return new ResponseEntity<Object>(RoleService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getByRoleNameAndCompany")
	public ResponseEntity<Object> getByCompanyName(@RequestParam String companyName, @RequestParam String roleName) {
		return new ResponseEntity<Object>(RoleService.findByRoleAndCompanyName(roleName, companyName), HttpStatus.OK);
	}
}
