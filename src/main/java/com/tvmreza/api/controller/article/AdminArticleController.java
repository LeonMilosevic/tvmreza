package com.tvmreza.api.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
