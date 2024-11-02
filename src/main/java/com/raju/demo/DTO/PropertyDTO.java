package com.raju.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PropertyDTO {
	
	private String title;
	private String description;
	private String address;
	private String price;
	
	
	
	public PropertyDTO() {
		super();
		// TODO Auto-generated constructor stub
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



	



	



	



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
	
	
	

}
