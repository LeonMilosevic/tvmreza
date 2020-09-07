package com.tvmreza.api.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.controller.category.dto.CategoryDtoRequest;
import com.tvmreza.api.entities.Article;
import com.tvmreza.api.entities.Category;
import com.tvmreza.api.repositories.CategoryRepository;
import com.tvmreza.api.services.category.PublicCategoryService;

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
	@Autowired
	PublicCategoryService publicCategoryService;

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<CategoryDtoRequest> readAllCategorySortedByCategoryOrder() {
		return publicCategoryService.readCategoryDtoRequest();
	}

	@GetMapping
	@RequestMapping("/read/articles/{id}")
	public List<Article> readCategoryArticles(@PathVariable("id") Long id) {
		return categoryRepository.findById(id).get().getArticles();
	}

	@GetMapping
	@RequestMapping("/read/articles/sliced/{id}")
	public List<Article> readCategoryArticlesSliced(@PathVariable("id") Long id) {
		return categoryRepository.findById(id).get().getArticles().subList(0, 4);
	}

}
