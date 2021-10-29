package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.login.exception.CustomException;
import com.login.modal.Company;
import com.login.modal.Role;
import com.login.repository.CompanyRepoitory;
import com.login.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private CompanyRepoitory companyRepoitory;

	public Object addRole(Role role) {
		if (role != null && StringUtils.hasText(role.getRole()) && role.getCompany() != null) {
			Role existingRole = roleRepository.getByRoleAndCompanyName(role.getRole(),
					role.getCompany().getCompanyName());
			if (existingRole != null)
				throw new CustomException("Role " + role.getRole() + " for same company already present",
						HttpStatus.FOUND);
			else {
				Company company = companyRepoitory.findByCompanyName(role.getCompany().getCompanyName());
				company.setActive(true);
				List<Role> roles = company.getRoles();
				Role newRole = new Role();
				newRole.setRole(role.getRole());
				roles.add(newRole);
				company.setRoles(roles);
				return companyRepoitory.save(company);
			}
		} else
			throw new CustomException("Role or company name not present", HttpStatus.FOUND);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role findByRole(String roleName) {
		Optional<Role> optional = roleRepository.findByRole(roleName);
		if (optional.isPresent())
			return optional.get();
		else
			return new Role();
	}

	public Role findByRoleAndCompanyName(String roleName, String companyName) {
		Role role = roleRepository.getByRoleAndCompanyName(companyName, roleName);
		if (role != null)
			return role;
		else
			return new Role();
	}
}
