package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByOrderByCategoryOrderAsc();

}
