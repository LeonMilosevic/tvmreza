package com.tvmreza.api.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmreza.api.entities.Category;
import com.tvmreza.api.exception.domain.CategoryException;
import com.tvmreza.api.repositories.CategoryRepository;

/**
 * title: Admin Category Service Impl Purpose: Allowing administrator to perform
 * CRUD functionality for Category entity class. methods: Self explanatory with
 * custom exception handling functions.
 * 
 * @see AdminCategoryController, AdminCategoryService
 * @author leon
 *
 */
@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category reqCategory) throws CategoryException {

		if (reqCategory.getCategoryOrder() == 0) // check if the category order is not null, since it needs to start
													// from 1.
		{
			throw new CategoryException("error");
		}
		if (reqCategory.getCategoryName().equals("")) // check if the category name is not empty
		{
			throw new CategoryException("error");
		}
		return categoryRepository.save(reqCategory);
	}

	@Override
	public Category readCategory(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Long id, Category reqCategory) {
		Category categoryToUpdate = categoryRepository.getOne(id);
		categoryToUpdate.setCategoryName(reqCategory.getCategoryName());
		categoryToUpdate.setCategoryOrder(reqCategory.getCategoryOrder());
		return categoryRepository.save(categoryToUpdate);
	}

	@Override
	public void removeCategory(Long id) {

		categoryRepository.deleteById(id);
		return;
	}

	@Override
	public List<Category> readAllCategorySortedByCategoryOrder() {
		return categoryRepository.findByOrderByCategoryOrderAsc();
	}

}
