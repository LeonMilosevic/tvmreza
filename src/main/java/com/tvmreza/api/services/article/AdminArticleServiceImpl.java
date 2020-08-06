package com.tvmreza.api.services.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmreza.api.controller.article.dto.ArticleDtoRequest;
import com.tvmreza.api.entities.Article;
import com.tvmreza.api.entities.Category;
import com.tvmreza.api.repositories.ArticleRepository;
import com.tvmreza.api.repositories.CategoryRepository;

@Service
public class AdminArticleServiceImpl implements AdminArticleService {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Article createArticle(ArticleDtoRequest articleDtoRequest) {
		System.out.println(articleDtoRequest.getCategoryId());

		Category category = categoryRepository.findById(articleDtoRequest.getCategoryId()).get();

		Article newArticle = new Article();

		newArticle.setCategory(category);
		newArticle.setKeywords(articleDtoRequest.getKeywords());
		newArticle.setVideoUrl(articleDtoRequest.getVideoUrl());
		newArticle.setImageUrl(articleDtoRequest.getImageUrl());
		newArticle.setContent(articleDtoRequest.getContent());
		newArticle.setHeader(articleDtoRequest.getHeader());
		newArticle.setAuthor(articleDtoRequest.getAuthor());
		newArticle.setDateDisplay(articleDtoRequest.getDateDisplay());

		System.out.println(newArticle.getDateDisplay());
		return articleRepository.save(newArticle);
	}

}
