package com.org.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
	String regNo;
	String docName;
	List<Patient> patientList;
	
	public Doctor(String regNo, String docName) {
		super();
		this.regNo = regNo;
		this.docName = docName;
		this.patientList= new ArrayList<Patient>();
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	
	
	public int addPatient(Patient p) {
		this.patientList.add(p);
		return this.patientList.size();
	}
	
	public int releasePatient(Patient p) {
		this.patientList.remove(p);
		return this.patientList.size();
	}

	@Override
	public String toString() {
		return "Doctor [regNo=" + regNo + ", docName=" + docName + ", patientList=" + patientList + "]";
	}
	
	

}
