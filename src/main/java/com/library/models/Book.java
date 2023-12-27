package com.library.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "books")
public class Book {
	@Id
	private String id;
	private String title;
	private int quantity;
	private boolean isPublished;
	private long availableCopies;
	private double price;
	
	@DBRef
	private Author author;
	
	public void setQuantity(int quantity) {
		if(quantity < 0) {
			throw new IllegalArgumentException("Quantity should be positive amount");
		}
		this.quantity = quantity;
	}
}
