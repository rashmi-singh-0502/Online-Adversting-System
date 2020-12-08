package com.cg.oas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "advertise")
public class AdEntity 
{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String advertiseTitle;

	@Column(name="category")
	private String advertiseCategory;
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String description;

	public AdEntity(int id,String advertiseTitle, String advertiseCategory, int price,String description) {
		super();
		this.id=id;
		this.advertiseTitle = advertiseTitle;
		this.advertiseCategory = advertiseCategory;
		this.price = price;
		this.description = description;
	}
	

	public AdEntity(String advertiseTitle, String advertiseCategory, int price, String description) {
		super();
		this.advertiseTitle = advertiseTitle;
		this.advertiseCategory = advertiseCategory;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getAdvertiseTitle() {
		return advertiseTitle;
	}

	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}

	public String getAdvertiseCategory() {
		return advertiseCategory;
	}

	public void setAdvertiseCategory(String advertiseCategory) {
		this.advertiseCategory = advertiseCategory;
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
		return "AdEntity [advertiseTitle=" + advertiseTitle + ", advertiseCategory=" + advertiseCategory + ", price="
				+ price + ", description=" + description + "]";
	}

	
	
}



