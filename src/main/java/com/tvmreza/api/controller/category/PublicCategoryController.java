package com.tvmreza.api.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Article;
import com.tvmreza.api.entities.Category;
import com.tvmreza.api.repositories.CategoryRepository;

/**
 * Public category controller, used for client requests. There is a method to
 * retrieve categories by order value, and a method to get all the articles from
 * that method.
 * 
 * @see CategoryRepository
 * @author leon
 *
 */
@RestController
@RequestMapping("/public/category")
public class PublicCategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Category> readAllCategorySortedByCategoryOrder() {
		return categoryRepository.findByOrderByCategoryOrderAsc();
	}

	@GetMapping
	@RequestMapping("/read/articles/{id}")
	public List<Article> readCategoryArticles(@PathVariable("id") Long id) {
		return categoryRepository.findById(id).get().getArticles();
	}
}
