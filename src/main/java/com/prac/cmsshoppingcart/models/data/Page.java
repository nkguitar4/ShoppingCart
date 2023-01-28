package com.prac.cmsshoppingcart.models.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="pages")
@Data
public class Page {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private int id;
	@Size(min=2, message="Title must be 2 charecters long")
	//@Column(name="title")
	private String title;
	//@Column(name="slug")
	private String slug;
	@Size(min=5, message="Content must be 2 charecters long")
	//@Column(name="content")
	private String content;
	//@Column(name="sorting")
	private int sorting;
	
	
	//no getters and setters due to lom-bok with Data annotation on the class

}
