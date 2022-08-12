package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {

	IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		List<Book> bookList=bookService.getAll();
		
		if(bookList==null) {
			return null;
		}
		if(bookList.isEmpty()) {
			throw new BookNotFoundException();
		}
		
		return bookList.stream().filter((book)->book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
		
	}

	

	public String addBook(Book book) {
		if(book==null) {
			return null;
		}
		bookService.addBook(book);
		return "book added";
	}

	public String showMessage(String name) {
		
		String result= bookService.greetMessage();
		if(name.startsWith("P")) {
			return result.concat(" ").concat(name);
		}
		else {
			return "wrong user";
		}	
	}
	
	List<Book> getAll() throws BookNotFoundException{
		
		return null;
		
	}
	
	public Book getById(int bookId) throws BookNotFoundException{
		
		return null;
	}
	
	public String orderBook(int bookId) throws BookNotFoundException {
		
		Book book=bookService.getById(bookId);
		if(book==null) {
			return "out of stock";
		}
		return "book ordered";
	}



}
