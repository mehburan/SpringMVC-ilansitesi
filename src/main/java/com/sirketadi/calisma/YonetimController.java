package com.sirketadi.calisma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class YonetimController {
	
	@RequestMapping(value = "/yonetim", method = RequestMethod.GET)
	public String yonetim() {
		return "admin/yonetim";
	}
	@RequestMapping(value = "/yonetim", method = RequestMethod.POST)
	public String yonetimm() {
		return "admin/yonetim";
	}
	@RequestMapping(value="/anasite", method=RequestMethod.GET)
	public String anasite() {
		return "admin/anasite";
	}

}
