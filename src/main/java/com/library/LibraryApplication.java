package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	
}

// TODO: Use Swagger to represent the API.
// TODO: Offering filtering by query params.
// TODO: Adding documentation for the functions.
// TODO: Adding logs with logs levels.
// TODO: Adding custom error handling.
// TODO: Adding the creationDate and the lastUpdatedDate.
// TODO: indexing on some fields.
// TODO: creating fields validator on the creation and updating.
// TODO: using the patch endpoint to update specific fields only.
