package com.library.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "authors")
public class Author {
	@Id
	private String id;
	private String name;
}
