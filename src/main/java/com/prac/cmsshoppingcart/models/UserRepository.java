package com.prac.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cmsshoppingcart.models.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
