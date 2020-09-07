package com.tvmreza.api.controller.category.dto;

/**
 * Data transfer object class, so we can return category without populated
 * articles, to avoid unnecessary data being transfered
 * 
 * @see Category
 * @author leon
 *
 */
public class CategoryDtoRequest {
	private Long id;
	private String categoryName;
	private byte categoryOrder;

	public CategoryDtoRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(byte categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

}
