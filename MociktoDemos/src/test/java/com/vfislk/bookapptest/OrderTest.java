package com.vfislk.bookapptest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

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
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderTest {

	@Mock
	IBookService bookService;
	
	@InjectMocks
	OrderDetails deatils=null;
	
	List<Book> bookList;
	Book book1,book2,book3;
	
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
		deatils=null;
	}

	@Test
	@DisplayName("Testing Book- returns one book instance")
	void testBookId() throws BookNotFoundException {
		doReturn(book1).when(bookService).getById(1);
		String actual=deatils.orderBook(1);
		assertEquals("book ordered", actual);
	}
	
	@Test
	@DisplayName("Testing Book- returns null")
	void testBookIdNull() throws BookNotFoundException {
		doReturn(null).when(bookService).getById(10);
		String actual=deatils.orderBook(10);
		assertEquals("out of stock", actual);
	}
	
	@Test
	@DisplayName("Testing Book- returns book added")
	void testAddBookNullCheck() throws BookNotFoundException {
		doReturn(null).when(bookService).addBook(book1);
		String actual=deatils.addBook(book1);
		assertEquals("book added", actual);
	}

}
