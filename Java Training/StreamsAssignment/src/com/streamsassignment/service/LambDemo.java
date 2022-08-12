package com.streamsassignment.service;

public class LambDemo {

	public static void main(String[] args) {
		
		IGames gamesList=(String[] games)->{
			for (String game : games) {
				System.out.print(game+" ");
			}
		};
		String[] listOfGames= {"voleyball","football","Cricket","Hockey"};
		gamesList.printGames(listOfGames);
	}
}
