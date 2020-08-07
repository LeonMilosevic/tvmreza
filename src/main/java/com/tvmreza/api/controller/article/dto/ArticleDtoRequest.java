package com.tvmreza.api.controller.article.dto;

import java.util.Date;

public class ArticleDtoRequest {
	private Long id;
	private Long categoryId;
	private String keywords;
	private String videoUrl;
	private String imageUrl;
	private String content;
	private String header;
	private String author;
	private int timesViewed;
	private Date dateDisplay;

	public ArticleDtoRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getTimesViewed() {
		return timesViewed;
	}

	public void setTimesViewed(int timesViewed) {
		this.timesViewed = timesViewed;
	}

	public Date getDateDisplay() {
		return dateDisplay;
	}

	public void setDateDisplay(Date dateDisplay) {
		this.dateDisplay = dateDisplay;
	}

}
