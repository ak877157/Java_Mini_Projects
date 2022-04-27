package com.org.assignment1;

public class DuplicateDoctorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public String getMessage() {
		return "Doctor with same Reg No Exist in the System";
		
	}

}
