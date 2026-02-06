package com.portfolio.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	Optional<Role> findByName(String name);
}
