package org.sid.springmvc.web;

import java.util.List;



import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {
	@Autowired
	private PatientRepository patientRepository; 
	
   @GetMapping("/listPatients")

   public List<Patient> list(){
	   return patientRepository.findAll();
   }
   @GetMapping("/patients/{id}")
 
   public Patient getOne(@PathVariable Long id){
	   return patientRepository.findById(id).get();
   }
      	
	
	
	

}
