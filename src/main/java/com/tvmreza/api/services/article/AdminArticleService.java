package com.tvmreza.api.services.article;

import java.util.List;

import com.tvmreza.api.controller.article.dto.ArticleDtoRequest;
import com.tvmreza.api.entities.Article;

public interface AdminArticleService {

	Article createArticle(ArticleDtoRequest articleDtoRequest);

	Article readArticleById(Long id);

	Article updateArticle(Long id, ArticleDtoRequest articleDtoRequest);

	String removeArticle(Long id);

	List<Article> readAllArticles();

}
