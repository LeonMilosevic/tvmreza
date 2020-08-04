package com.tvmreza.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "footerbanner")
public class Footerbanner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imageUrl;
	private String linkToUrl;
	private byte footerbannerOrder;

	public Footerbanner() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLinkToUrl() {
		return linkToUrl;
	}

	public void setLinkToUrl(String linkToUrl) {
		this.linkToUrl = linkToUrl;
	}

	public byte getFooterbannerOrder() {
		return footerbannerOrder;
	}

	public void setFooterbannerOrder(byte footerbannerOrder) {
		this.footerbannerOrder = footerbannerOrder;
	}

}
