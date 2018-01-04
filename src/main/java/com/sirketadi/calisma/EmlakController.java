package com.sirketadi.calisma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmlakController {

	@RequestMapping(value="/admin/emlak", method=RequestMethod.GET) //url
	public String Emlak( Model model) {
		return "admin/emlak"; //JspApplicationContext gonderici
	}
}
