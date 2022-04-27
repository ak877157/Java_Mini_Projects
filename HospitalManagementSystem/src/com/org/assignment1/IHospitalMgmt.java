package com.org.assignment1;

public interface IHospitalMgmt {
	int registerDoctor(Doctor d) throws DuplicateDoctorException;
	int hospitalizePateint(String regNo, Patient p) throws PatientExistException;
	int releasePatient(int patientId);
	Doctor retrieveDoctorInfo(int patientId);
	int PatientCountPerCity(String city);

}
