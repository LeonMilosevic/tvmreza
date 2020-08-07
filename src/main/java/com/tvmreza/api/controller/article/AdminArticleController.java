package com.tvmreza.api.controller.article;

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

import com.tvmreza.api.controller.article.dto.ArticleDtoRequest;
import com.tvmreza.api.entities.Article;
import com.tvmreza.api.services.article.AdminArticleService;

@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

	@Autowired
	AdminArticleService adminArticleService;

	@PostMapping
	@RequestMapping("/create")
	public Article createArticle(@RequestBody ArticleDtoRequest articleDtoRequest) {
		return adminArticleService.createArticle(articleDtoRequest);
	}

	@GetMapping
	@RequestMapping("/read/{id}")
	public Article readArticle(@PathVariable("id") Long id) {
		return adminArticleService.readArticleById(id);
	}

	@PutMapping
	@RequestMapping("/update/{id}")
	public Article readArticle(@PathVariable("id") Long id, @RequestBody ArticleDtoRequest articleDtoRequest) {
		return adminArticleService.updateArticle(id, articleDtoRequest);
	}

	@DeleteMapping
	@RequestMapping("/remove/{id}")
	public String removeArticle(@PathVariable("id") Long id) {
		return adminArticleService.removeArticle(id);
	}

	@GetMapping
	@RequestMapping("/read/all")
	public List<Article> readAllArticles() {
		return adminArticleService.readAllArticles();
	}
}
