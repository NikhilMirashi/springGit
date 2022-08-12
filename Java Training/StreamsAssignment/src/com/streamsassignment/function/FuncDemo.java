package com.streamsassignment.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FuncDemo {
public static void main(String[] args) {
	Function <String, List<String> > function=(str)->{
		
		List<String> individualElementList=Arrays.asList(str.split(" "));
		return individualElementList;
		
	};
	List<String> individualElementList =function.apply("Java is fun");
	for (String individualElement : individualElementList) {
		System.out.println(individualElement);
	}
	
}
}
