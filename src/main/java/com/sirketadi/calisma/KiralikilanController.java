package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.Ekiralik;
import Utils.EkiralikEnum;
import Utils.Esatilik;
import Utils.UrunResim;
import Utils.UrunResimEnum;

@Controller
public class KiralikilanController {
	DB db = new DB();
	List<Ekiralik> ls = new ArrayList<Ekiralik>();
	List<UrunResim> ukk = new ArrayList<UrunResim>();
	@RequestMapping(value="admin/kiralikilan/{id}")
	public String kirailan(Model model, @PathVariable(value="id")String id) {
try {
			ls = new ArrayList<Ekiralik>();
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
			ukk = new ArrayList<UrunResim>();
				String query ="select *from urun_resimleri where urun_id=2";
				ResultSet urs = db.baglan().executeQuery(query);
				while(urs.next()) {
					UrunResim ur = new UrunResim();
					ur.setUadi(urs.getString(""+UrunResimEnum.adi));
					ukk.add(ur);
					
				}
			} catch (Exception e) {
				System.err.println("Kiralýk Ýlan Site Resim Hatasý: "+e);
			}
		for (Ekiralik ekiralik : ls) {
			if (ekiralik.getEkid().equals(id)) {
				model.addAttribute("ekiralik", ekiralik);
				System.out.println("esitlik kontrolu:"+id);
				break;
			}
		}
			model.addAttribute("ls", ls);
			model.addAttribute("id", 2);
			model.addAttribute("ukk", ukk);
		return "admin/kiralikilan";
	}
}
