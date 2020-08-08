package com.tvmreza.api.controller.post.dto;

import java.sql.Timestamp;

/**
 * Post dto, to accept client body request, to persist article id to article
 * object, and later populate the same article object with current post
 * 
 * @see Post, PublicPostService
 * @author leon
 *
 */
public class PostDtoRequest {
	private Long id;
	private Long articleId;
	private String username;
	private String textContent;
	private Timestamp dateCreated;

	public PostDtoRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

}
