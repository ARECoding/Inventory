package com.inventory.demo.response;

import java.util.List;
import com.inventory.demo.model.Category;

import lombok.Data;

@Data
public class CategoryResponse {
	private List<Category> category;

}
