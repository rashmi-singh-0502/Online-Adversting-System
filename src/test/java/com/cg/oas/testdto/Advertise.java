package com.cg.oas.testdto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Advertise
{
	@Min(value=1)
	private Long ad_id;
	
	@NotBlank
	@NotNull
	private String title;
	
	
	@NotBlank
	@NotNull
	private String description;
	
	@Min(value=100)
	@Max(value=1000000)
	private double price;
	
	@NotBlank
	@NotNull
	private String status;
	private Category category;
	
	public Advertise(Long ad_id, String title, String description, double price, String status) {
		super();
		this.ad_id = ad_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	public Advertise(String title, String description, double price, String status) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	public Advertise() {
	}
	
	public Advertise(Long ad_id,String title, String description, double price,String status, Category category) {
		super();
		this.ad_id = ad_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Advertise [ad_id=" + ad_id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", status=" + status + ", category=" + category + "]";
	}
}
