package com.tvmreza.api.services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvmreza.api.controller.post.dto.PostDtoRequest;
import com.tvmreza.api.entities.Article;
import com.tvmreza.api.entities.Post;
import com.tvmreza.api.repositories.ArticleRepository;
import com.tvmreza.api.repositories.PostRepository;

@Service
public class PublicPostServiceImpl implements PublicPostService {

	@Autowired
	PostRepository postRepository;
	@Autowired
	ArticleRepository articleRepository;

	@Override
	/**
	 * We get a new post dto request, we take the article id from it, connect
	 * article with article object field in Post entity, we update fields, and we
	 * add post in to article that was passed from postDtoRequest.
	 * 
	 * @return saved post
	 */
	public Post createPost(PostDtoRequest postDtoRequest) throws Exception {
		Article article = articleRepository.getOne(postDtoRequest.getArticleId());
		Post newPost = new Post();

		if (postDtoRequest.getUsername().isEmpty() || postDtoRequest.getTextContent().isEmpty()) {
			throw new Exception();
		} else {
			newPost.setArticle(article);
			newPost.setUsername(postDtoRequest.getUsername());
			newPost.setTextContent(postDtoRequest.getTextContent());

			article.getPosts().add(newPost);

			return postRepository.save(newPost);
		}
	}

}
