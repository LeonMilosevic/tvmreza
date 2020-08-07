package com.tvmreza.api.services.category;

import java.util.List;

import com.tvmreza.api.entities.Category;
import com.tvmreza.api.exception.domain.CategoryException;

/**
 * title: Admin Category Service
 * Purpose: Allowing administrator to perform CRUD functionality for Category entity class.
 * methods: Self explanatory.
 * @see AdminCategoryController, AdminCategoryServiceImpl
 * @author leon
 *
 */
public interface AdminCategoryService {

	public Category createCategory(Category category) throws CategoryException;

	public Category readCategory(Long id);

	public Category updateCategory(Long id, Category category);

	public void removeCategory(Long id);

	public List<Category> readAllCategorySortedByCategoryOrder();
}
