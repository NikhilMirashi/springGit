package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	
	List<Book> getAll() throws BookNotFoundException;
	List<Book> getByLessPrice(double price);
	
	Book getById(int bookId) throws BookNotFoundException;
	void addBook(Book book);
	
	
	public String showMessage(String name);
	public String greetMessage();

}
