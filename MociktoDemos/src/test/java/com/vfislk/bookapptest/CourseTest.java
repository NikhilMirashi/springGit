package com.vfislk.bookapptest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.service.Course;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CourseTest {
	
	@Spy
	Course course;
	
	@Mock
	Course mcourse;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	//	course=new Course();
	}

	@AfterEach
	void tearDown() throws Exception {
		course=null;
	}

	@Test
	@DisplayName("testing showCourses")
	void testShowCourse() {
		
	List<String> expected=Arrays.asList("Java","Jsp","Springs");
	assertEquals(expected, course.showCourses());
	assertEquals(3, course.showCourses().size());
	assertNotNull(expected);
		
	}
	
	@Test
	@DisplayName("testing showCoursesSpy")
	void testShowCourseSpy() {
		
		List<String> courses=course.showCourses();
		System.out.println(courses);
	
	}
	
	@Test
	@DisplayName("testing showCoursesMock")
	void testShowCourseMock() {
		when(mcourse.showCourses()).thenReturn(Arrays.asList("Java","Jsp"));
		List<String> courses=mcourse.showCourses();
		System.out.println(courses);
	
	}

}
