package com.org.assignment1;

public class PatientExistException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public String getMessage() {
		return "Patient with given PAN already hospitalized";
	}
}
