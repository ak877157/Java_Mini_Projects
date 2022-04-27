package com.org.assignment1;

public class Patient {
	String uId;
	int patientId;
	String patientName;
	String city;
	public Patient(String uId, String patientName, String city) {
		super();
		this.uId = uId;
		this.patientName = patientName;
		this.city = city;
		this.patientId=IDGenerator.next();
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Patient [uId=" + uId + ", patientId=" + patientId + ", patientName=" + patientName + ", city=" + city
				+ "]";
	}
	
	
	

}
