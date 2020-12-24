package com.cg.oas.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class Advertise
{
	@Min(value=1)
	@ApiModelProperty(value="Advertise ID")
	private Long ad_id;
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Advertise Title")
	private String title;
	
	
	@NotBlank
	@NotNull
	@ApiModelProperty(value="Advertise Description")
	private String description;
	
	@Min(value=100)
	@Max(value=1000000)
	@ApiModelProperty(value="Advertise Price")
	private double price;
	
	@ApiModelProperty(value="Advertise category")
	private Category category;
	
	public Advertise(Long ad_id, String title, String description, double price) {
		super();
		this.ad_id = ad_id;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public Advertise(String title, String description, double price) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public Advertise() {
	}
	
	public Advertise(Long ad_id,String title, String description, double price,Category category) {
		super();
		this.ad_id = ad_id;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Advertise [ad_id=" + ad_id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}
}
