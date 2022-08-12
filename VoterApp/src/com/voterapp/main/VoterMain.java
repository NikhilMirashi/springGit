package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.service.IElectionBooth;
import com.voterapp.service.IElectionBoothImpl;

public class VoterMain {

	public static void main(String[] args) {
		
		IElectionBooth electionBooth=new IElectionBoothImpl();
		Scanner sc=new Scanner(System.in);
		System.out.print("enter the age:");
		int age=sc.nextInt();
		System.out.print("enter the locality:");
		String locality=sc.next();
		System.out.print("enter the voterId:");
		int voterId=sc.nextInt();
		
		try {
			if(electionBooth.checkEligiblity(age, locality, voterId)) {
				System.out.println("congrats you can vote and Happy Voting..!");
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}
