package com.voterapp.service;

import com.voterapp.exception.InvaliVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIdException;
import com.voterapp.exception.UnderAgeException;

public class IElectionBoothImpl implements IElectionBooth {

	@Override
	public boolean checkEligiblity(int age, String locality, int voterId) throws InvaliVoterException {

		try {
			if (checkVoterId(age) && checkLocality(locality) && checkAge(age)) {
				return true;
			}
		} catch (NoVoterIdException e) {
			System.out.println(e.getMessage());
			
		} catch (LocalityNotFoundException e) {
			System.out.println(e.getMessage());
			
		} catch (UnderAgeException e) {
			System.out.println(e.getMessage());
			
		}

		throw new InvaliVoterException("Invalid Voter");
	}

	private boolean checkAge(int age) throws UnderAgeException {
		if (age >= 18) {
			return true;
		}
		throw new UnderAgeException("sorry not able to vote your age is not under 18");

	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		String[] localities = { "mysore,bangalore" };
		if (locality.equalsIgnoreCase("bangalore")) {
			return true;
		} else if (locality.equalsIgnoreCase("mysore")) {
			return true;
		}
		throw new LocalityNotFoundException("sorry your locality is not found you cannot vote");

	}

	private boolean checkVoterId(int voterId) throws NoVoterIdException {

		if (voterId >= 1000 || voterId <= 9999) {
			return true;
		}
		throw new NoVoterIdException("Sorry your voter id not exists");

	}

}
