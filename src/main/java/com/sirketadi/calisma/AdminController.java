package com.sirketadi.calisma;


import java.awt.Dialog.ModalExclusionType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Utils.Admin;
import Utils.DB;

@Controller
public class AdminController {
	


	
	@RequestMapping(value="/giris/kulduzenle" , method=RequestMethod.POST)
	public String adminDuzen(Model model) {
		String durum="";
		DB db = new DB();
		Admin adm = new Admin();
		try {
			String query = "UPDATE admin set adpassword='"+adm.getSifre()+"' where adid=1";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				durum="Þifre Deðiþimi Baþarýlý ";
			}
		} catch (Exception e) {
			System.err.println("Düzenle Hatasý: "+e);
		}
		model.addAttribute("durum",durum);
		return "giris";
	}
	
}
