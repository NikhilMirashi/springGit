package com.vfislk.training;

import com.vfislk.exceptions.GreaterValueException;
import com.vfislk.exceptions.NegValueException;

public class Student {
	
	public int calcTotal(int a,int b,int c) throws NegValueException, GreaterValueException {
		
		if(a<0||b<0||c<0) {
			throw new NegValueException("Negative marks not consider");
		}
		if(a>100||b>100||c>100) {
			throw new GreaterValueException("Negative marks not consider");
		}
		return(a+b+c);
	}
	
	public String getGrades(int[] marks) throws NegValueException, GreaterValueException {
		int sum=0;
		if(marks==null) {
			return "enter marks please";
		}
		for (int mark : marks) {
			if(mark<0) {
				throw new NegValueException();
			}
			if(mark>100) {
				throw new GreaterValueException();
			}
			 sum+=mark;
		}
		int avg=sum/marks.length;
		String grade = null;
		
		if(avg>=90 ) {
			grade="A";
		}
		if(avg>=80 && avg<90) {
			grade="B";
		}
		if(avg>=60 && avg<80) {
			grade="C";
		}
		if(avg>=50 && avg<60) {
			grade="D";
		}
		if(avg<50) {
			grade="Fail";
		}
		return grade;
		
	}

}
