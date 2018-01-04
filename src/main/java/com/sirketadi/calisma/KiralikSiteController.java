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

@Controller
public class KiralikSiteController {
	DB db = new DB();
	@RequestMapping(value="/kiraliksite")
	public String kiraliksite(Model model ) {
		List<UrunResim> us = new ArrayList<UrunResim>();
		List<Ekiralik> ls = new ArrayList<Ekiralik>();
		try {
			
			String query="select *from ekiralik";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				Ekiralik ek = new Ekiralik();
				ek.setEkid(rs.getString(""+EkiralikEnum.ekid));
				ek.setEkbaslik(rs.getString(""+EkiralikEnum.ekbaslik));
				ek.setEkacik(rs.getString(""+EkiralikEnum.ekacik));
				ek.setEkdetay(rs.getString(""+EkiralikEnum.ekdetay));
				ek.setEkfiyat(rs.getString(""+EkiralikEnum.ekfiyat));
				ls.add(ek);
			}
		} catch (Exception e) {
			System.err.println("Kiralik Site Hatasý: "+e);
		}
		try {
			
			String query ="select *from urun_resimleri where urun_id=2";
			ResultSet urs = db.baglan().executeQuery(query);
			while(urs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(urs.getString(""+UrunResimEnum.adi));
				us.add(ur);
				
			}
		} catch (Exception e) {
			System.err.println("Kiralýk Site Resim Hatasý: "+e);
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 2);
		model.addAttribute("us", us.get(0).getUadi());
		return "admin/kiraliksite";
	}
}
