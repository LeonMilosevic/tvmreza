package com.tvmreza.api.controller.article;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Article;
import com.tvmreza.api.repositories.ArticleRepository;

/**
 * Public Article controller, to read queries available for client side. Methods
 * can retrieve articles ordered by most recent, and by most viewed.
 * 
 * @see ArticleRepository
 * @author leon
 *
 */
@RestController
@RequestMapping("/public/article")
public class PublicArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@GetMapping
	@RequestMapping("/read/{id}")
	public Article readArticle(@PathVariable("id") Long id) {
		Article foundArticle = articleRepository.findById(id).get();
		int currentTimesViewed = foundArticle.getTimesViewed();
		foundArticle.setTimesViewed(++currentTimesViewed);
		articleRepository.save(foundArticle);
		return foundArticle;
	}

	@GetMapping
	@RequestMapping("/read/all/newest")
	public List<Article> readArticlesByNewest(
			@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") final int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return articleRepository.findByOrderByDateDisplayDesc(pageable);
	}

	@GetMapping
	@RequestMapping("/read/all/mostviewed")
	public List<Article> readArticlesByMostViewed(
			@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") final int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return articleRepository.findByOrderByTimesViewedDesc(pageable);
	}

	@GetMapping
	@RequestMapping("/read/by/{keyword}")
	public List<Article> readArticlesByKeyword(@PathVariable("keyword") String keyword) {
		List<Article> articles = articleRepository.findByKeywordsOrderByDateDisplayDesc(keyword);

		return articles;
	}

	@GetMapping
	@RequestMapping("/read/by/category/{id}")
	public List<Article> readArticleByCategory(@PathVariable("id") Long id,
			@RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") final int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Article> articlesByCategory = articleRepository.findByCategoryIdOrderByDateDisplayDesc(id, pageable);
		return articlesByCategory;
	}

}
