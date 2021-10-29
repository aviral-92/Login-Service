package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//public Long findIdByCompanyName(String name);

	Optional<User> findByUsername(String username);

	public boolean existsByUsername(String username);
}
