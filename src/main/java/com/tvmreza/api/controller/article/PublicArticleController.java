package com.tvmreza.api.controller.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tvmreza.api.entities.Article;
import com.tvmreza.api.repositories.ArticleRepository;

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
	public List<Article> readArticlesByNewest() {
		return articleRepository.findByOrderByDateDisplayDesc();
	}

	@GetMapping
	@RequestMapping("/read/all/mostviewed")
	public List<Article> readArticlesByMostViewed() {
		return articleRepository.findByOrderByTimesViewedDesc();
	}

}
