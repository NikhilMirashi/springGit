package com.streamsassignment.fruits;

import java.util.Arrays;
import java.util.Optional;

public class FruitsDemo {

	public static void main(String[] args) {
		
		Optional<String> optionalString= Arrays.asList("apple","berrybee","strawberry","kevy")
		.stream().filter((str)->str.contains("berry")).findFirst();
		
		if(optionalString.isPresent()) {
			String value=optionalString.get();
			System.out.println(value);
		}
	}

	
}
