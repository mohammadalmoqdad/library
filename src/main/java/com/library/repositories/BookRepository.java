package com.library.repositories;

import com.library.DAOs.BookDAO;
import com.library.DTOs.BookDTO;
import com.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class BookRepository implements BookDAO {
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public BookRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Book> findAll() {
		return mongoTemplate.findAll(Book.class);
	}
	
	@Override
	public Book findById(String id) {
		Book result = mongoTemplate.findById(id, Book.class);
		if (result == null) {
			throw new NoSuchElementException("Book not found with id: " + id);
		}
		return result;
	}
	
	@Override
	public List<Book> getBooksByAuthorName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("author.name").is(name));
		List<Book> queryResult = mongoTemplate.find(query, Book.class);
		if (queryResult.size() == 0) {
			throw new NoSuchElementException("Books not found with author name: " + name);
		}
		return queryResult;
	}
	
	@Override
	public Book save(Book book) {
		return mongoTemplate.save(book);
	}
	
	@Override
	public Book update(String id, BookDTO updatedBook) {
		Book book = mongoTemplate.findById(id, Book.class);
		if (book == null) {
			throw new NoSuchElementException("Book not found with id: " + id);
		}
		return mongoTemplate.updateFirst()
	}
	
	@Override
	public void delete(String id) {
		Book book = mongoTemplate.findById(id, Book.class);
		if (book == null) {
			throw new NoSuchElementException("Book not found with id: " + id);
		}
		mongoTemplate.remove(book);
	}
	
}
