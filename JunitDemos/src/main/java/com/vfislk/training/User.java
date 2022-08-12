package com.vfislk.training;

import java.util.Arrays;
import java.util.List;

public class User {

	public String greet(String userName) {
		return "welcome " + userName;
	}

	public List<String> showFruits() {
		return Arrays.asList("apple", "mango", "kivi");
	}

	public int countFruits() {

		List<String> fruitsList = Arrays.asList("apple", "mango", "kivi");
		return fruitsList.size();
	}

}
