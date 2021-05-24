package org.sid.springmvc.web;

import java.util.List;

import org.sid.springmvc.dao.DoctorRepository;
import org.sid.springmvc.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DoctorPathController {
	@Autowired
	private DoctorRepository doctorRepository; 
	
   @GetMapping("/listDoctors")

   public List<Doctor> list(){
	   return doctorRepository.findAll();
   }
   @GetMapping("/doctors/{id}")
 
   public Doctor getOne(@PathVariable Long id){
	   return doctorRepository.findById(id).get();
   }
      	
	
	
	

}
