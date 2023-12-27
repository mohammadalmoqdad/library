package com.library.controllers;

import com.library.DTOs.BookDTO;
import com.library.models.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping("/create")
	public Book createBook(@ModelAttribute Book book) {
		Book createdBook = bookService.addBook(book);
		return ResponseEntity.ok(createdBook);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable String id, @ModelAttribute BookDTO bookUpdateDTO) {
		Book updatedBook = bookService.updateBook(id, bookUpdateDTO);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
	
}
