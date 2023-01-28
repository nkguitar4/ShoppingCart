package com.prac.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cmsshoppingcart.models.data.Admin;
import com.prac.cmsshoppingcart.models.data.User;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByUsername(String username);

}
