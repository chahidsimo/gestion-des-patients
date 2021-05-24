package org.sid.springmvc;

import java.util.Date;

import org.sid.springmvc.dao.DoctorRepository;
import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Doctor;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//patientRepository.deleteAll();
		patientRepository.save(new Patient(null,"nimo",new Date(),false,566));
		patientRepository.save(new Patient(null,"saad",new Date(),true,133));
		patientRepository.save(new Patient(null,"salma",new Date(),false,200));
		patientRepository.save(new Patient(null,"radi",new Date(),true,450));
		patientRepository.findAll().forEach(p->{
			System.out.println(p.getName());
			//patientRepository.deleteAll();
		});
		System.out.println("***************************************");
		
		doctorRepository.save(new Doctor(null,"anas","ghali","Cardio",new Date()));
		doctorRepository.save(new Doctor(null,"omar","kabir","Dentist",new Date()));
		doctorRepository.save(new Doctor(null,"farid","chahid","Generalist",new Date()));
		doctorRepository.findAll().forEach(d->{
			System.out.println(d.getName());
		});
	}

}
