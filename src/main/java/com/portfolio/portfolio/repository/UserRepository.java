package com.portfolio.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	boolean existByEmail(String email);
	Optional<User> findByEmail(String email);
}
