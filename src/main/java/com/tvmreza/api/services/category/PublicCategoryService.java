package com.tvmreza.api.services.category;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tvmreza.api.controller.category.dto.CategoryDtoRequest;

public interface PublicCategoryService {
	public List<CategoryDtoRequest> readCategoryDtoRequest();
}
