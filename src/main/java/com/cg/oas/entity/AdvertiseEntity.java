package com.cg.oas.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="advertise")
public class AdvertiseEntity {

	@Id
	@GeneratedValue
	@Column(name="ad_id")
	private Long ad_id;

	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	private CategoryEntity category;
	
	public AdvertiseEntity(Long ad_id,String title,String description, double price,CategoryEntity category) {
		this.ad_id = ad_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	public AdvertiseEntity() {
	}
	
	public AdvertiseEntity(String title, String description, double price, CategoryEntity category) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	public Long getAd_id() {
		return ad_id;
	}
	public void setAd_id(Long ad_id) {
		this.ad_id = ad_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "AdvertiseEntity [ad_id=" + ad_id + ", title=" + title + ", description=" + description + ", price="
				+ price + ", category=" + category + "]";
	}
}