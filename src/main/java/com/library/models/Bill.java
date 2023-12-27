package com.library.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collation = "bills")
public class Bill {
	@Id
	private String id;
	private String customerId;
	private List<Book> bookItems;
	private double totalPrice;
}
