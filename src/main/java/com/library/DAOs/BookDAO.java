package com.library.DAOs;

import com.library.models.Book;

import java.util.List;

public interface BookDAO extends DAO<Book> {
	List<Book> getBooksByAuthorName(String name);
}
