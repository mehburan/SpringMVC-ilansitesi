package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Utils.DB;
import Utils.Esatilik;
import Utils.EsatilikEnum;
import Utils.UrunResim;
import Utils.UrunResimEnum;;

@Controller
public class SatilikController {
	DB db = new DB();
	@RequestMapping(value = "admin/satilik")
	public String satGor(Model model) {
		List<UrunResim> uls = new ArrayList<UrunResim>();
		try {
			String adi="";
			String query = "select *from urun_resimleri where urun_id=1";
			ResultSet rs = db.baglan().executeQuery(query);
			while (rs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(rs.getString("" + UrunResimEnum.adi));
				adi=ur.getUadi();
				uls.add(ur);
				System.out.println(ur.getUadi());
				System.out.println("Hatal�y�m");
				model.addAttribute("adi", adi);
			}
		} catch (Exception e) {
			System.err.println("Sat�l�k Resim Getirme Hatas�: " + e);
		}
		
		model.addAttribute("uls", uls);
		model.addAttribute("id", "1");
		model.addAttribute("ls", satlistele());
		return "admin/satilik";
	}
	@RequestMapping(value = "satilik/sil/{id}")
	public String satsil(@PathVariable(value = "id") String id, Model model) {
		try {
			System.out.println("delete controller");
			String query = "delete from esatilik where esid='" + id + "'";
			int deger = db.baglan().executeUpdate(query);
			if (deger > 0) {
				return "redirect:/admin/satilik";
			}
		} catch (Exception e) {
			System.err.println("Sat�l�k Silme Hatas�: " + e);
		}
		model.addAttribute("ls", satlistele());

		return "redirect:/admin/satilik";
	}

	@RequestMapping(value = "/satilik", method = RequestMethod.POST)
	public String satkaydet(Esatilik es, Model model) {
		String durum = "";
		try {
			String query = "insert into esatilik (esid,esbaslik,esacik,esdetay,esresim,esfiyat)" + " values (null,'"
					+ es.getEsbaslik() + "', '" + es.getEsacik() + "', '" + es.getEsdetay() + "'," + "'"
					+ es.getEsresim() + "','" + es.getEsfiyat() + "')";
			int deger = db.baglan().executeUpdate(query);
			if (deger > 0) {
				durum = "Ekleme Ba�ar�l�";
			} else {
				durum = "Ekleme Ba�ar�s�z";
			}
		} catch (Exception e) {
			System.err.println("Sat�l�k Ekleme Hatas�: " + e);
		}
		model.addAttribute("durum", durum);
		model.addAttribute("ls", satlistele());
		return "redirect:/admin/satilik";
	}

	public List satlistele() {
		DB db = new DB();

		List<Esatilik> ls = new ArrayList<Esatilik>();
		try {
			String query = "select *from esatilik";
			ResultSet rs = db.baglan().executeQuery(query);
			while (rs.next()) {
				Esatilik es = new Esatilik();
				es.setEsid(rs.getString("" + EsatilikEnum.esid));
				es.setEsbaslik(rs.getString("" + EsatilikEnum.esbaslik));
				es.setEsacik(rs.getString("" + EsatilikEnum.esacik));
				es.setEsdetay(rs.getString("" + EsatilikEnum.esdetay));
				es.setEsresim(rs.getString("" + EsatilikEnum.esresim));
				es.setEsfiyat(rs.getString("" + EsatilikEnum.esfiyat));
				ls.add(es);
			}
		} catch (Exception e) {
			System.err.println("Sat G�r Hatas�: " + e);
		}

		return ls;

	}

	@RequestMapping(value = "/satduzenle/{id}", method = RequestMethod.GET)
	public String satduzenle(Model model, @PathVariable(value = "id") String id) {
		Esatilik es = new Esatilik();
		try {

			String query = "select * from esatilik where esid=" + id;
			System.out.println(query);
			ResultSet rs = db.baglan().executeQuery(query);

			rs.next();
			es.setEsid(rs.getString("" + EsatilikEnum.esid));
			es.setEsbaslik(rs.getString("" + EsatilikEnum.esbaslik));
			es.setEsacik(rs.getString("" + EsatilikEnum.esacik));
			es.setEsdetay(rs.getString("" + EsatilikEnum.esdetay));
			es.setEsresim(rs.getString("" + EsatilikEnum.esresim));
			es.setEsfiyat(rs.getString("" + EsatilikEnum.esfiyat));

		} catch (Exception e) {
			System.err.println("D�zenleme Hatas�: " + e);
		}
		model.addAttribute("es", es);
		model.addAttribute("id", "1");
		model.addAttribute("ls", satlistele());
		return "redirect:/admin/satduzenle";
	}

	@RequestMapping(value = "/satduzenle", method = RequestMethod.POST)
	public String satiduzenle(Esatilik es, Model model) {

		String id = es.getEsid();
		String durum = "";
		try {
			String query = "update esatilik set esbaslik='" + es.getEsbaslik() + "'," + " esacik='" + es.getEsacik()
					+ "', esdetay='" + es.getEsdetay() + "', " + "esresim='" + es.getEsresim() + "', esfiyat='"
					+ es.getEsfiyat() + "' where esid='" + id + "'";
			System.out.println(query);
			int deger = db.baglan().executeUpdate(query);
			if (deger > 0) {
				System.out.println("Sat�l�k D�zenleme ekleme ba�ar�l�");
				durum = "D�zenle Ekle Ba�ar�l�";
				return "redirect:/admin/satilik";
			} else {
				durum = "D�zenle Ekle Ba�ar�l� De�il !";
			}
		} catch (Exception e) {
			System.err.println("Sat�l�k D�zenle-Ekle Hatas�: " + e);
		}
		model.addAttribute("es", es);
		model.addAttribute("durum", durum);
		model.addAttribute("ls", satlistele());

		return "redirect:/admin/satilik";
	}
}
