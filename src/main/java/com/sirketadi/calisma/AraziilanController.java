package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.Esatilik;
import Utils.UrunResim;
import Utils.UrunResimEnum;
import Utils.Varazi;
import Utils.VaraziEnum;

@Controller
public class AraziilanController {
DB db = new DB();
List<Varazi> ls = new ArrayList<Varazi>();
List<UrunResim> us = new ArrayList<UrunResim>();
	@RequestMapping(value="admin/araziilan/{id}")
	public String arazilan(Model model, @PathVariable(value="id")String id) {
		
		try {
			ls = new ArrayList<Varazi>();
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
		us = new ArrayList<UrunResim>();
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
		for (Varazi varazi : ls) {
			if (varazi.getVaid().equals(id)) {
				model.addAttribute("varazi", varazi);
				System.out.println("esitlik kontrolu:"+id);
				break;
			}
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 4);
		model.addAttribute("us", us);
		return "admin/araziilan";
	}
}
