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
import Utils.Votomobil;
import Utils.VotomobilEnum;

@Controller
public class OtomobilSiteController {
	DB db = new DB();
	@RequestMapping(value="/otosite")
	public String otomobilsite(Model model) {
		List<UrunResim> us = new ArrayList<UrunResim>();
		List<Votomobil> ls = new ArrayList<Votomobil>();
		try {
			
			String query="select *from votomobil";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				Votomobil vo = new Votomobil();
				vo.setVoidd(rs.getString(""+VotomobilEnum.voidd));
				vo.setVobaslik(rs.getString(""+VotomobilEnum.vobaslik));
				vo.setVoacik(rs.getString(""+VotomobilEnum.voacik));
				vo.setVodetay(rs.getString(""+VotomobilEnum.vodetay));
				vo.setVofiyat(rs.getString(""+VotomobilEnum.vofiyat));
				ls.add(vo);
			}
		} catch (Exception e) {
			System.err.println("Otomobil Site Hatasý: "+e);
		}
		try {
			
			String query ="select *from urun_resimleri where urun_id=3";
			ResultSet urs = db.baglan().executeQuery(query);
			while(urs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(urs.getString(""+UrunResimEnum.adi));
				us.add(ur);
				
			}
		} catch (Exception e) {
			System.err.println("Otomobil Site Resim Hatasý: "+e);
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 3);
		model.addAttribute("us", us.get(0).getUadi());
		return "admin/otosite";
	}
}
