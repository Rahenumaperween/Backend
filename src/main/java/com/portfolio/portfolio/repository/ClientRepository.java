package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.entity.Client;

public interface ClientRepository  extends JpaRepository<Client,Long>{
	 boolean existsByName(String name);

}
