package com.voterapp.model;

public class Voter {
	
	
	private int voterId;
	private int age;
	private String locality;
	
	public Voter(int voterId, int age, String locality) {
		this.voterId = voterId;
		this.age = age;
		this.locality = locality;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", age=" + age + ", locality=" + locality + "]";
	}
	
	
	
	
}
