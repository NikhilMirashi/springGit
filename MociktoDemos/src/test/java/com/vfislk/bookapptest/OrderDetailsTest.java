package com.vfislk.bookapptest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	@Mock
	IBookService bookService; // mock IBookService

	@InjectMocks
	OrderDetails details;

	List<Book> bookList = null;
	Book book1, book2, book3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book(1, "Java", "nikhil", 300);
		book2 = new Book(2, "springs", "akhil", 400);
		book3 = new Book(3, "Java", "nikhil", 350);
		bookList = Arrays.asList(book1, book2, book3);
	}

	@AfterEach
	void tearDown() throws Exception {
		details = null;
	}

	@Test
	void testShowMessage() {
		Mockito.when(bookService.greetMessage()).thenReturn("Great Day");
		String actual = details.showMessage("Priya");
		assertEquals("Great Day Priya", actual);
		String nactual = details.showMessage("Prachi");
		assertEquals("Great Day Prachi", nactual);
	}

	@Test
	void testAnShowMessage() {
		Mockito.when(bookService.greetMessage()).thenReturn("Great Day");

		String actual = details.showMessage("Raj");
		assertEquals("wrong user", actual);

		String nactual = details.showMessage("Ravi");
		assertEquals("wrong user", nactual);
	}

	@Test
	@DisplayName("Testing by author - getAll by author")
	void testgetAll() throws BookNotFoundException {

		Mockito.when(bookService.getAll()).thenReturn(bookList);
		String author = "nikhil";
		List<Book> actualBooks = details.findByAuthor(author);
		List<Book> expectedBooks = Arrays.asList(book1, book3);
		assertEquals(expectedBooks, actualBooks);
	}

	@Test
	@DisplayName("Testing by author - throw exception")
	void testgetAuthorException() throws BookNotFoundException {

		Mockito.when(bookService.getAll()).thenThrow(new BookNotFoundException());
		String author = "nikhil";
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
	}
	
	@Test
	@DisplayName("Testing by author - throw emptyList")
	void testgetAuthorEmpty() throws BookNotFoundException {

		Mockito.when(bookService.getAll()).thenReturn(new ArrayList<Book>());
		String author = "nikhil";
		assertThrows(BookNotFoundException.class, ()->details.findByAuthor(author));
	}
	
	@Test
	@DisplayName("Testing by author -  null")
	void testgetAuthorNull() throws BookNotFoundException {

		Mockito.when(bookService.getAll()).thenReturn(null);
		String author = "nikhil";
		List<Book> actualBooks = details.findByAuthor(author);
		assertNull(actualBooks);
		
	}

}
