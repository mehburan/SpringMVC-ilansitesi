package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.Ekiralik;
import Utils.EkiralikEnum;
import Utils.UrunResim;
import Utils.UrunResimEnum;
import Utils.Varazi;
import Utils.VaraziEnum;
@Controller
public class AraziSiteController {
	DB db = new DB();
	@RequestMapping(value="/arazisite")
	public String kamsite(Model model) {
		List<UrunResim> us = new ArrayList<UrunResim>();
		List<Varazi> ls = new ArrayList<Varazi>();
		try {
			
			String query="select *from varazi";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				Varazi vz = new Varazi();
				vz.setVaid(rs.getString(""+VaraziEnum.vaid));
				vz.setVabaslik(rs.getString(""+VaraziEnum.vabaslik));
				vz.setVaacik(rs.getString(""+VaraziEnum.vaacik));
				vz.setVadetay(rs.getString(""+VaraziEnum.vadetay));
				vz.setVafiyat(rs.getString(""+VaraziEnum.vafiyat));
				ls.add(vz);
			}
		} catch (Exception e) {
			System.err.println("Arazi Site Hatasý: "+e);
		}
		try {
			
			String query ="select *from urun_resimleri where urun_id=4";
			ResultSet urs = db.baglan().executeQuery(query);
			while(urs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(urs.getString(""+UrunResimEnum.adi));
				us.add(ur);
				
			}
		} catch (Exception e) {
			System.err.println("Arazi Site Resim Hatasý: "+e);
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 4);
		model.addAttribute("us", us.get(0).getUadi());
	
		return "admin/arazisite";
	}
}
