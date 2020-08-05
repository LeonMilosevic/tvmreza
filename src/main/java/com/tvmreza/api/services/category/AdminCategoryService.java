package com.tvmreza.api.services.category;

import java.util.List;

import com.tvmreza.api.entities.Category;
import com.tvmreza.api.exception.domain.CategoryException;

public interface AdminCategoryService {

	public Category createCategory(Category category) throws CategoryException;

	public Category readCategory(Long id);

	public Category updateCategory(Long id, Category category);

	public void removeCategory(Long id);

	public List<Category> readAllCategory();
}
