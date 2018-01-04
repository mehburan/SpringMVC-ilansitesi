package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Utils.Admin;
import Utils.AdminEnum;
import Utils.DB;


@Controller
public class GirisController {
	
	@RequestMapping(value = "/giris", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("girisKontrol", true);
		return "admin/giris";
	}

	@RequestMapping(value = "/giris", method = RequestMethod.POST)
	public String giris(Admin ad,Model model) {
		System.out.println("dsdfadfadf");
		boolean girisKontrol = true;
		DB db = new DB();
		Admin adm = new Admin();
		try {
			String query ="select * from admin";
			ResultSet rs= db.baglan().executeQuery(query);
			while(rs.next()) {
				adm.setId(rs.getString(""+AdminEnum.adid));
				adm.setAdi(rs.getString(""+AdminEnum.adname));
				adm.setSifre(rs.getString(""+AdminEnum.adpassword));
			
			}
			
		} catch (Exception e) {
			System.err.println("Admin hatasý: "+e);
		}
		System.out.println(adm.getAdi());
		System.out.println(adm.getSifre());
		if (ad.getAdi().equals(adm.getAdi())) {
			if (ad.getSifre().equals(adm.getSifre())) {
				model.addAttribute("durum","Giris Doðru");
				girisKontrol = true;
				model.addAttribute("girisKontrol", girisKontrol);
				return "redirect:/yonetim";
			}
			System.out.println("-------"+ad.getAdi());
			System.out.println(ad.getSifre());
		}
		else {
			System.out.println("yanlýþ giris");
			
			model.addAttribute("durum","Giris Yanlýþ");
			girisKontrol = false;
			System.out.println("giris KONTROL:"+girisKontrol);
			model.addAttribute("girisKontrol", girisKontrol);
			return "redirect:/giris";
		}
		
		
		return "admin/giris";
	}
	
}
