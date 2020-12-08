package com.cg.oas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="advertise")
public class AdvertiseEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ad_id")
	private int ad_id;

	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@Column(name="status")
	private String status;
	
	public AdvertiseEntity(int ad_id, String title, String category, String description, double price, String status) {
		super();
		this.ad_id = ad_id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	
	public AdvertiseEntity(String title, String category, String description, double price, String status) {
		super();
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	public AdvertiseEntity() {
	}
	
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [ad_id=" + ad_id + ", title=" + title + ", category=" + category + ", description="
				+ description + ", price=" + price + ", status=" + status + "]";
	}	
}
