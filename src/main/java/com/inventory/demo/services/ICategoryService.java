package com.inventory.demo.services;

import org.springframework.http.ResponseEntity;

import com.inventory.demo.response.CategoryResponseRest;

public interface ICategoryService {
	public ResponseEntity<CategoryResponseRest> search();
	public ResponseEntity<CategoryResponseRest> searchById(Long id);
}
