package com.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

//	@GetMapping("/")
//	public List<Author> getAllAuthors() {
//		return AuthorService.getAuthor()
//	}

//	@GetMapping("/{id}")
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAuthor() {
	
	}
	
	
}
