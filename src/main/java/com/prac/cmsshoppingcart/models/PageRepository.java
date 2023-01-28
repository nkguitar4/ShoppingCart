package com.prac.cmsshoppingcart.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cmsshoppingcart.models.data.Page;

public interface PageRepository extends JpaRepository<Page, Integer> {
	
	Page findBySlug(String slug);
	
	Page findBySlugAndIdNot(String slug,int id);
	
	List<Page> findAllByOrderBySortingAsc();

}
