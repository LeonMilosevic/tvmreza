package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByOrderByDateDisplayDesc();

	List<Article> findByOrderByTimesViewedDesc();

}
