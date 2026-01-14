package com.inventory.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Category")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4310027227752446841L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;


	// public Categpry(Long id, String name, String description) {
	// 	this.setId(id);
	// 	this.setName(name);
	// 	this.setDescription(description);
	// }


	// public String getname() {
	// 	return this.name;
	// }
	

	// public Long getId() {
	// 	return id;
	// }

	// private void setId(Long id) {
	// 	this.id = id;
	// }

	// private void setName(String name) {
	// 	this.name = name;
	// }

	// public String getDescription() {
	// 	return this.description;
	// }

	// private void setDescription(String description) {
	// 	this.description = description;
	// }






}
