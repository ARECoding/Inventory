package com.inventory.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventory.demo.model.Category;

public interface ICategoryDao extends CrudRepository <Category, Long> {
	
}
