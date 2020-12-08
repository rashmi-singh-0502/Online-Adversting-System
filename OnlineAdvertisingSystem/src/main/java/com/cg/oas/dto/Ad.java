package com.cg.oas.dto;
public class Ad 
{
	private String advertiseTitle;
	private String category;
	private int price;
	private String description;
	
	public Ad(String advertiseTitle, String category, int price, String description) {
		super();
		this.advertiseTitle = advertiseTitle;
		this.category = category;
		this.price = price;
		this.description = description;
	}

	public Ad() {
		super();
	}

	public String getAdvertiseTitle() {
		return advertiseTitle;
	}

	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [advertiseTitle=" + advertiseTitle + ", category=" + category + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
}
