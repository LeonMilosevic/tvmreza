package com.tvmreza.api.services.article;

import java.util.List;

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

		Category category = categoryRepository.getOne(articleDtoRequest.getCategoryId());

		Article newArticle = new Article();

		newArticle.setCategory(category);
		newArticle.setCategoryName(category.getCategoryName());
		newArticle.setKeywords(articleDtoRequest.getKeywords());
		newArticle.setVideoUrl(articleDtoRequest.getVideoUrl());
		newArticle.setImageUrl(articleDtoRequest.getImageUrl());
		newArticle.setContent(articleDtoRequest.getContent());
		newArticle.setHeader(articleDtoRequest.getHeader());
		newArticle.setAuthor(articleDtoRequest.getAuthor());
		newArticle.setDateDisplay(articleDtoRequest.getDateDisplay());

		category.getArticles().add(newArticle);
		return articleRepository.save(newArticle);
	}

	@Override
	public Article readArticleById(Long id) {
		return articleRepository.findById(id).get();
	}

	/**
	 * Updating the article, getting the article to update from articleDtoRequest,
	 * updating changed fields, if category is changed as well, removing article
	 * from previous category, adding article to new category
	 * 
	 * @return returns an updated article
	 */

	@Override
	public Article updateArticle(Long id, ArticleDtoRequest articleDtoRequest) {
		Article articleToUpdate = articleRepository.findById(id).get(); // article that needs to
																		// get updated

		// fields that need to be changed
		articleToUpdate.setKeywords(articleDtoRequest.getKeywords());
		articleToUpdate.setVideoUrl(articleDtoRequest.getVideoUrl());
		articleToUpdate.setImageUrl(articleDtoRequest.getImageUrl());
		articleToUpdate.setContent(articleDtoRequest.getContent());
		articleToUpdate.setHeader(articleDtoRequest.getHeader());
		articleToUpdate.setAuthor(articleDtoRequest.getAuthor());
		articleToUpdate.setDateDisplay(articleDtoRequest.getDateDisplay());

		// check if there is an update field for new category
		if (articleDtoRequest.getCategoryId() != articleToUpdate.getCategory().getId()) {

			// getting the old category and removing the article from the list
			articleToUpdate.getCategory().getArticles().remove(articleToUpdate.getId());

			// getting the new category from articleDtoRequest and updating it in the
			// article class,
			// and pushing the article in to category class
			Category newCategory = categoryRepository.getOne(articleDtoRequest.getCategoryId());
			articleToUpdate.setCategory(newCategory);
			articleToUpdate.setCategoryName(newCategory.getCategoryName());
			newCategory.getArticles().add(articleToUpdate);
		}

		return articleRepository.save(articleToUpdate);
	}

	@Override
	public String removeArticle(Long id) {
		articleRepository.deleteById(id);
		return "Success";
	}

	@Override
	public List<Article> readAllArticles() {
		return articleRepository.findAll();
	}

}
