package com.tvmreza.api.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Category;
import com.tvmreza.api.exception.domain.CategoryException;
import com.tvmreza.api.services.category.AdminCategoryService;

/**
 * Admin Category Controller. Allowing administrator to perform CRUD
 * functionality for Category entity class.
 * 
 * @see AdminCategoryService, AdminCategoryServiceImpl
 * @author leon
 *
 */
@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController extends Exception {

	@Autowired
	AdminCategoryService adminCategoryService;

	@PostMapping
	@RequestMapping("/create")
	public Category createCategory(@RequestBody Category reqCategory) throws CategoryException {
		return adminCategoryService.createCategory(reqCategory);
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Category readCategory(@PathVariable("id") Long id) {
		return adminCategoryService.readCategory(id);
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category reqCategory) {
		return adminCategoryService.updateCategory(id, reqCategory);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeCategory(@PathVariable("id") Long id) {
		adminCategoryService.removeCategory(id);
		return "Success";
	}

	@GetMapping
	@RequestMapping("/read/all/ordered")
	public List<Category> readAllCategorySortedByCategoryOrder() {
		System.out.println("here");
		return adminCategoryService.readAllCategorySortedByCategoryOrder();
	}
}
