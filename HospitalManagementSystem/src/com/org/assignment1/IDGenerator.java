package com.org.assignment1;

public class IDGenerator {
	private static int id=1;
	
	public static int next() {
		int inc=id++;
		return inc;
	}

}
