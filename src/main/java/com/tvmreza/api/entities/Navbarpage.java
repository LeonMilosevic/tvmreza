package com.tvmreza.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "navbarpage")
public class Navbarpage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String navbarName;
	private byte navbarOrder;
	private String header;
	private String content;
	private String imagesUrl;
	private String videoUrl;

	public Navbarpage() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNavbarName() {
		return navbarName;
	}

	public void setNavbarName(String navbarName) {
		this.navbarName = navbarName;
	}

	public byte getNavbarOrder() {
		return navbarOrder;
	}

	public void setNavbarOrder(byte navbarOrder) {
		this.navbarOrder = navbarOrder;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}
