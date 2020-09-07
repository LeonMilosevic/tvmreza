package com.tvmreza.api.services.category;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tvmreza.api.controller.category.dto.CategoryDtoRequest;
import com.tvmreza.api.entities.Category;
import com.tvmreza.api.repositories.CategoryRepository;

@Service
public class PublicCategoryServiceImpl implements PublicCategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<CategoryDtoRequest> readCategoryDtoRequest() {
		List<Category> categories = categoryRepository.findByOrderByCategoryOrderAsc();

		ModelMapper modelMapper = new ModelMapper();
		List<CategoryDtoRequest> categoryDtoList = categories.stream()
				.map(category -> modelMapper.map(category, CategoryDtoRequest.class)).collect(Collectors.toList());

		return categoryDtoList;
	}

}
