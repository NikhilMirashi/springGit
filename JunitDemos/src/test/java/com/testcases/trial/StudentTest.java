package com.testcases.trial;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeTags;

import com.vfislk.exceptions.GreaterValueException;
import com.vfislk.exceptions.NegValueException;
import com.vfislk.training.Student;

class StudentTest {

	Student student;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	void testCalcTotal() throws NegValueException, GreaterValueException {

		int actual = student.calcTotal(10, 20, 10);
		assertEquals(40, actual);
		assertEquals(50, student.calcTotal(20, 20, 10));
	}

	@Test
	void testNegTotal() {
		assertThrows(NegValueException.class, ()->student.calcTotal(-90, 90, 30));
		//assertThrows(NegValueException.class, ()->student.calcTotal(120, 90, 30));
	}
	
	@Test
	void testGreaterTotal() {
		assertThrows(GreaterValueException.class, ()->student.calcTotal(120, 90, 30));
	}
	
	
	@Tag("A")
	@Test
	@DisplayName("Testing grade-A")
	void testGradeA() throws NegValueException, GreaterValueException  {
		int[] marks= {90,90};
		System.out.println(student.getGrades(marks));
		assertEquals("A", student.getGrades(marks));
	}
	
	@Tag("B")
	@Test
	@DisplayName("Testing grade-B")
	void testGradeB() throws NegValueException, GreaterValueException  {
		int[] marks= {80,80};
		System.out.println(student.getGrades(marks));
		assertEquals("B", student.getGrades(marks));
	}
	
	@Tag("C")
	@Test
	@DisplayName("Testing grade-C")
	void testGradeC() throws NegValueException, GreaterValueException  {
		int[] marks= {70,70};
		System.out.println(student.getGrades(marks));
		assertEquals("C", student.getGrades(marks));
	}
	@Test
	@DisplayName("Testing grade-D")
	void testGradeD() throws NegValueException, GreaterValueException  {
		int[] marks= {50,50};
		System.out.println(student.getGrades(marks));
		assertEquals("D", student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing grade-Fail")
	void testGradeFail() throws NegValueException, GreaterValueException  {
		int[] marks= {40,40};
		System.out.println(student.getGrades(marks));
		assertEquals("Fail", student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing negative Value")
	void testLessvalue()  {
		int[] marks= {-40,40};
		assertThrows(NegValueException.class, ()->student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing greater Value")
	void testGreaterValue()  {
		int[] marks= {120,40};
		assertThrows(GreaterValueException.class, ()->student.getGrades(marks));
	}
	
	@Test
	@DisplayName("Testing AssertValue")
	void testAssertValue()  {
		int[] marks= null;
		assertNull(null, marks);
	}

}
