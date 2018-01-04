package com.sirketadi.calisma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VasitaController {

	@RequestMapping(value="/admin/vasita" ,method=RequestMethod.GET)
	public String vasitaGor(Model model) {
		
		return "admin/vasita";
	}
}
