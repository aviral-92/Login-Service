package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.modal.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByRole(String name);

	@Query(nativeQuery = true, value = "select r.* from roles r inner join company c on c.id = r.company_id "
			+ "where c.company_name = ? AND r.role = ? ")
	Role getByRoleAndCompanyName(String name, String companyName);
}