package com.tvmreza.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tvmreza.api.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	List<Article> findByOrderByDateDisplayDesc(Pageable pageable);

	List<Article> findByOrderByTimesViewedDesc(Pageable pageable);

	List<Article> findByKeywordsOrderByDateDisplayDesc(String keyword);

	List<Article> findByCategoryIdOrderByDateDisplayDesc(Long id, Pageable pageable);

	List<Article> findByOrderByDateDisplayDesc();

}
