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
import Utils.UrunResim;
import Utils.UrunResimEnum;
import Utils.Votomobil;
import Utils.VotomobilEnum;

@Controller
public class OtomobililanController {
	DB db = new DB();
	List<Votomobil> ls = new ArrayList<Votomobil>();
	List<UrunResim> uos = new ArrayList<UrunResim>();
	@RequestMapping(value="admin/otoilan/{id}")
	public String otoilan(Model model,@PathVariable(value="id")String id) {
		
		try {
			ls = new ArrayList<Votomobil>();
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
			uos = new ArrayList<UrunResim>();
				String query ="select *from urun_resimleri where urun_id=3";
				ResultSet urs = db.baglan().executeQuery(query);
				while(urs.next()) {
					UrunResim ur = new UrunResim();
					ur.setUadi(urs.getString(""+UrunResimEnum.adi));
					uos.add(ur);
					
				}
			} catch (Exception e) {
				System.err.println("Otomobil Site Resim Hatasý: "+e);
			}
		for (Votomobil votomobil : ls) {
			if (votomobil.getVoidd().equals(id)) {
				model.addAttribute("votomobil", votomobil);
				System.out.println("esitlik kontrolu:"+id);
				break;
			}
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 3);
		model.addAttribute("uos", uos);
		return "admin/otoilan";
	}
}
