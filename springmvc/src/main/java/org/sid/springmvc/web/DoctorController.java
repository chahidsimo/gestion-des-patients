package org.sid.springmvc.web;

import javax.validation.Valid;

import org.sid.springmvc.dao.DoctorRepository;
import org.sid.springmvc.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DoctorController {
	@Autowired
	private DoctorRepository doctorRepository; 

	/*
	 * @GetMapping(path="/index") public String index() { return "index"; }
	 */
	@GetMapping(path="/doctors")
	public String list(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size,
			@RequestParam(name="keyword",defaultValue="")String mc)
	{
		Page<Doctor> pageDoctors= doctorRepository.findByNameContains(mc, PageRequest.of(page, size));
		model.addAttribute("doctors",pageDoctors.getContent());
		model.addAttribute("pages",new int[pageDoctors.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("keyword",mc);
		return "doctors";
	}
	@GetMapping(path="/deleteDoctor")
	public String delete(Long id,String keyword,int page, int size)
	{   doctorRepository.deleteById(id);
		return "redirect:/doctors?page="+page+"&size="+size+"&keyword="+keyword;
	}
  
   @GetMapping(path="/formDoctor")
    public String formDoctor(Model model) {
	   model.addAttribute("doctor",new Doctor());
	   model.addAttribute("mode","new");
    	return "formDoctor";
    	
    }
   @PostMapping("/saveDoctor")
   public String saveDoctor(Model model,@Valid Doctor doctor, BindingResult bindingResult) {
	   if(bindingResult.hasErrors()) return "formDoctor";		   
	   doctorRepository.save(doctor);
	   model.addAttribute("doctor",doctor);
	   return "d_confirmation";
   }
    
   @GetMapping(path="/editDoctor")
   public String editDoctor(Model model,Long id) {
	   Doctor d=doctorRepository.findById(id).get();
	   model.addAttribute("doctor",d);
	   model.addAttribute("mode","edit");
   	return "formDoctor";
   	
   }
}