package com.cg.oas.dto;

public class Ad
{
	private int ad_id;
	private String title;
	private String category;
	private String description;
	private double price;
	private String status;
	public Ad(int ad_id, String title, String category, String description, double price, String status) {
		super();
		this.ad_id = ad_id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	public Ad(String title, String category, String description, double price, String status) {
		super();
		this.title = title;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	public Ad() {
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
		return "Advertise [ad_id=" + ad_id + ", title=" + title + ", category=" + category + ", description="
				+ description + ", price=" + price + ", status=" + status + "]";
	}
}