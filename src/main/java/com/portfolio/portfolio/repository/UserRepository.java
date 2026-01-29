package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
