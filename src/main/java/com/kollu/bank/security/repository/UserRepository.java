package com.kollu.bank.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kollu.bank.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	 User findByUserName(String username);

}
