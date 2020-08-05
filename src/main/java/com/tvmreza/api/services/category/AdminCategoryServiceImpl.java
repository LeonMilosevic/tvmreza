package com.tvmreza.api.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmreza.api.entities.Category;
import com.tvmreza.api.exception.domain.CategoryException;
import com.tvmreza.api.repositories.CategoryRepository;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category reqCategory) throws CategoryException {
		if (reqCategory.getCategoryOrder() == 0) {
			throw new CategoryException("error");
		}
		if (reqCategory.getCategoryName().equals("")) {
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
		Category category = categoryRepository.findById(id).get();
		category.setCategoryName(reqCategory.getCategoryName());
		category.setCategoryOrder(reqCategory.getCategoryOrder());
		return category;
	}

	@Override
	public void removeCategory(Long id) {

		categoryRepository.deleteById(id);
		return;
	}

	@Override
	public List<Category> readAllCategory() {
		return categoryRepository.findAll();
	}

}
