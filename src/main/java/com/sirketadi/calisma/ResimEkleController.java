package com.sirketadi.calisma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResimEkleController {

	@RequestMapping(value="/resimekle/{id}" ,method=RequestMethod.GET)
	public String resimekleme(@PathVariable(value="id") String id,Model model) {
		model.addAttribute("id", id);
	return "admin/resimekle";	
	}
	
	
}
