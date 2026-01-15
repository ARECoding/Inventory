package com.inventory.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.demo.dao.ICategoryDao;
import com.inventory.demo.response.CategoryResponseRest;
import com.inventory.demo.model.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			List<Category> categoryList = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(categoryList);
			response.setMetadata("respuesta OK", "00", "respuesta exitosa");

		} catch (Exception err) {
			response.setMetadata("Respuesta no OK", "-1", "falle la peticion");
			err.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {

		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> list = new ArrayList<>();
		try {
			
			Optional<Category> category = categoryDao.findById(id);
			if(category.isPresent()) {
				list.add(category.get());
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("respuesta OK", "00", "respuesta exitosa");
			}else {
				response.setMetadata("Fallo la peticion", "-1", "No se encontro la categoria");	
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception err) {
			response.setMetadata("Respuesta no OK", "-1", "falle la peticion");
			err.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);

	}

}
