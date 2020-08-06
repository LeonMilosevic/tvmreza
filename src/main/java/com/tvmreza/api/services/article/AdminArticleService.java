package com.tvmreza.api.services.article;

import com.tvmreza.api.controller.article.dto.ArticleDtoRequest;
import com.tvmreza.api.entities.Article;

public interface AdminArticleService {

	Article createArticle(ArticleDtoRequest articleDtoRequest);

}
