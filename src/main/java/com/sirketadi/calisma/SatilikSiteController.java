package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.Esatilik;
import Utils.EsatilikEnum;
import Utils.UrunResim;
import Utils.UrunResimEnum;

@Controller
public class SatilikSiteController {
	DB db = new DB();
	@RequestMapping(value="/satiliksite")
	public String satiliksite(Model model) {
		
		
		List<UrunResim> us = new ArrayList<UrunResim>();
		List<Esatilik> ls = new ArrayList<Esatilik>();
		try {
			String query="select *from esatilik";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				Esatilik es = new Esatilik();
				es.setEsid(rs.getString(""+EsatilikEnum.esid));
				es.setEsbaslik(rs.getString(""+EsatilikEnum.esbaslik));
				es.setEsacik(rs.getString(""+EsatilikEnum.esacik));
				es.setEsdetay(rs.getString(""+EsatilikEnum.esdetay));
				es.setEsfiyat(rs.getString(""+EsatilikEnum.esfiyat));
				ls.add(es);
			}
		} catch (Exception e) {
			System.err.println("Satýlýk Site Hatasý: "+e);
		}
		try {
			String query ="select *from urun_resimleri where urun_id=1";
			ResultSet urs = db.baglan().executeQuery(query);
			while(urs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(urs.getString(""+UrunResimEnum.adi));
				us.add(ur);
				
			}
		} catch (Exception e) {
			System.err.println("Satýlýk Site Resim Hatasý: "+e);
		}
		//model.addAttribute("us", us);
		model.addAttribute("ls", ls);
		model.addAttribute("id", 1);
		model.addAttribute("us", us.get(0).getUadi());
		
		
		return "admin/satiliksite";
	}
}
