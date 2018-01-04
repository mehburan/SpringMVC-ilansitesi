package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.Esatilik;
import Utils.EsatilikEnum;
import Utils.UrunResim;
import Utils.UrunResimEnum;

@Controller
public class SatilikilanController {
	DB db = new DB();
	List<UrunResim> uss = new ArrayList<UrunResim>();
	List<Esatilik> ls = new ArrayList<Esatilik>();
	@RequestMapping(value="admin/satilikilan/{id}")
	public String satilan(Model model, @PathVariable(value="id")String id) {
		try {
			ls = new ArrayList<Esatilik>();
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
			uss = new ArrayList<UrunResim>();
				String query ="select *from urun_resimleri where urun_id=1";
				ResultSet urs = db.baglan().executeQuery(query);
				while(urs.next()) {
					UrunResim ur = new UrunResim();
					ur.setUadi(urs.getString(""+UrunResimEnum.adi));
					uss.add(ur);
					
				}
			} catch (Exception e) {
				System.err.println("Satýlýk Ýlan Site Resim Hatasý: "+e);
			}
		
		for (Esatilik esatilik : ls) {
			if (esatilik.getEsid().equals(id)) {
				model.addAttribute("esatilik", esatilik);
				System.out.println("esitlik kontrolu:"+id);
				break;
			}
		}
			model.addAttribute("ls", ls);
			model.addAttribute("id", 1);
			model.addAttribute("uss", uss);
			
		return "admin/satilikilan";
	}
}
