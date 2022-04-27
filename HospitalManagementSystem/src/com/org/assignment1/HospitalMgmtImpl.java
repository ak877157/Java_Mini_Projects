package com.org.assignment1;

import java.util.*;

public class HospitalMgmtImpl implements IHospitalMgmt {

	List<Doctor> doctorList = new ArrayList<Doctor>();
	
	
	@Override
	public int registerDoctor(Doctor d) throws DuplicateDoctorException{
		// TODO Auto-generated method stub
		int docListSize=-1;
		
		for(Doctor doc : doctorList) {
			if(doc.regNo==d.regNo) {
				throw new DuplicateDoctorException();
			}
		}
		doctorList.add(d);
		docListSize = doctorList.size();
		
		return docListSize;
		
	}

	@Override
	public int hospitalizePateint(String regNo, Patient p) throws PatientExistException{
		// TODO Auto-generated method stub
		Doctor treatingDoc = null;
		for(Doctor d : doctorList) {
			if(d.regNo==regNo) {
				treatingDoc=d;
			}
			
			for(Patient pat : d.patientList) {
				if(pat.uId==p.uId) {
					throw new PatientExistException();
				}
			}
		}
		
		if(treatingDoc!=null) {
			treatingDoc.patientList.add(p);
		}
		if(treatingDoc==null) {
			return -1;
		}else
			return treatingDoc.patientList.size();
	}

	@Override
	public int releasePatient(int patientId) {
		// TODO Auto-generated method stub
		int patListSize=-1;
		
		for(Doctor doc : doctorList) {
			for(Patient pat : doc.patientList) {
				if(pat.patientId==patientId) {
					doc.patientList.remove(pat);
					patListSize = doc.patientList.size();
					break;
				}
			}
		}
		
		
		return patListSize;
	}

	@Override
	public Doctor retrieveDoctorInfo(int patientId) {
		// TODO Auto-generated method stub
		Doctor d1 = new  Doctor();
		for(Doctor doc : doctorList) {
			for(Patient p : doc.patientList) {
				if(p.patientId==patientId) {
					d1=doc;
				}
			}
		}
		return d1;
		
	}

	@Override
	public int PatientCountPerCity(String city) {
		// TODO Auto-generated method stub
		int count=0;
		
		for(Doctor doc : doctorList) {
			for(Patient p : doc.patientList) {
				if(p.city==city) {
					count++;
					break;
				}
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Doctor d1 = new  Doctor("D101", "Ashish Raghuwanshi");
		Doctor d2 = new  Doctor("D102", "Nayra Singh");
		Doctor d3 = new  Doctor("D103", "Sonu Jain");
		
		
		Patient p1 = new Patient("P101", "Manoj Tiwari", "Delhi");
		Patient p2 = new Patient("P102", "Jyoti Kumari", "Bihar");
		Patient p3 = new Patient("P103", "Dilpreet Kaur", "Chandigarh");
		
		
		HospitalMgmtImpl h1 = new HospitalMgmtImpl();
		System.out.println("************************");
		System.out.println("Doctor Registration");
		try {
			
			h1.registerDoctor(d1);
			h1.registerDoctor(d2);
			h1.registerDoctor(d3);
		} catch (DuplicateDoctorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		System.out.println("************************");
		System.out.println("Hospitalized Patient");
		try {
			h1.hospitalizePateint("D101", p1);
			h1.hospitalizePateint("D102", p2);
			h1.hospitalizePateint("D103", p3);
		}catch (PatientExistException e) {
			//TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(h1.doctorList);

		System.out.println("************************");
		System.out.println("Doctor's Info for particular patient");
		System.out.println("Doctor Information for patient 1 : "+h1.retrieveDoctorInfo(1).docName);
		System.out.println("Doctor Information for patient 2 : "+h1.retrieveDoctorInfo(2).docName);
		

		
		System.out.println("************************");
		System.out.println("Released Patient Information");
		System.out.println("Released Patient "+h1.releasePatient(1));
		
		System.out.println(h1.doctorList);
	}

}
