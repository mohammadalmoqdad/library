package com.library.repositories;

import com.library.DAOs.AuthorDAO;
import com.library.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository implements AuthorDAO {
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public AuthorRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Author> findAll() {
		return mongoTemplate.findAll(Author.class, "authors");
	}
	
	@Override
	public Author findById(String id) {
		return mongoTemplate.findById(id, Author.class, "authors");
	}
	
	@Override
	public Author save(Author author) {
		return null;
	}
	
	@Override
	public Author update(String id, Author author) {
		return null;
	}
	
	@Override
	public void delete(String id) {
	
	}
}
