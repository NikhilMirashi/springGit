package com.voterapp.service;

import com.voterapp.exception.InvaliVoterException;

public interface IElectionBooth {
	
	boolean checkEligiblity(int age,String locality,int voterId) throws InvaliVoterException;
}
