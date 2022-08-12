package com.testcases.demo.check;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vfislk.training.User;

class UserTest {

	User user;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
	}

	@Test
	void testUserName() {
		assertEquals("welcome nikhil", user.greet("nikhil"));
	}
	
	@Test
	void testShowFruits() {
		
		List<String> fruitsList=Arrays.asList("apple", "mango", "kivi");
		assertEquals(fruitsList, user.showFruits());
	}
	
	@Test
	void testcountFruits() {
		assertEquals(3, user.showFruits().size());
	}
	
	
	
	
	

}
