package com.library.DTOs;

import lombok.Data;

@Data
public class BookDTO {
	private String title;
	private int quantity;
	private boolean isPublished;
	private long availableCopies;
	private double price;
	private String authorId;
}