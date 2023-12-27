package com.library.services;

import com.library.DTOs.BookDTO;
import com.library.models.Author;
import com.library.models.Book;
import com.library.repositories.AuthorRepository;
import com.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	
	public List<Book> getBooksByAuthorName(String name) {
		return bookRepository.getBooksByAuthorName(name);
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book addBook(BookDTO bookDTO) {
		Author author = authorRepository.findById(bookDTO.getAuthorId());
		if (author == null){
			throw new NoSuchElementException("Author not found with id: " + bookDTO.getAuthorId());
		}
		
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(bookDTO.getTitle());
		book.setQuantity(bookDTO.getQuantity());
		book.setPublished(bookDTO.isPublished());
		book.setAvailableCopies(bookDTO.getAvailableCopies());
		book.setPrice(bookDTO.getPrice());
		
		return bookRepository.save(book);
		
	}
	
	public Book updateBook(String bookId, BookDTO bookDTO) {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new NoSuchElementException("Book not found with id: " + bookId));
		
		if (bookDTO.getTitle() != null) book.setTitle(bookDTO.getTitle());
		if (bookDTO.getQuantity() < 0) book.setQuantity(bookDTO.getQuantity());
		if (bookDTO.getPublished() isIstance false) book.setPublished(bookDTO.getPublished());
		
		if (bookDTO.getAuthorId() != null) {
			Author author = bookRepository.findById(bookDTO.getAuthorId(), Author.class);
			if (author == null) {
				throw new NoSuchElementException("Author not found with id: " + bookDTO.getAuthorId());
			}
			book.setAuthor(author);
		}
		
		return bookRepository.save(book);
	}
	
	public void deleteBook(String id) {
		bookRepository.delete(id);
	}
	
	
}
