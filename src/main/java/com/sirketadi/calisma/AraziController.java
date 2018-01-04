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
import Utils.UrunResim;
import Utils.UrunResimEnum;
import Utils.Varazi;
import Utils.VaraziEnum;

@Controller
public class AraziController {
	DB db = new DB();
	@RequestMapping(value = "admin/arazi")
	public String arazGor(Model model) {
		List<UrunResim> uaz = new ArrayList<UrunResim>();
		try {
			String adi="";
			String query = "select *from urun_resimleri where urun_id=4";
			ResultSet rs = db.baglan().executeQuery(query);
			while (rs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(rs.getString("" + UrunResimEnum.adi));
				adi=ur.getUadi();
				uaz.add(ur);
				System.out.println(ur.getUadi());
				model.addAttribute("adi", adi);
			}
		} catch (Exception e) {
			System.err.println("Arazi Resim Getirme Hatasý: " + e);
		}
		
		model.addAttribute("uaz", uaz);
		model.addAttribute("id", "4");
		model.addAttribute("ls", arazlistele());
		return "admin/arazi";
	}
	 @RequestMapping(value="/sil/{id}")
	 public String arazsil(@PathVariable(value="id")String id, Model model) {
		 try {
			 System.out.println("delete controller");
			String query="delete from varazi where vaid='"+id+"'";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				return "redirect:/admin/arazi";
			}
		} catch (Exception e) {
			System.err.println("Arazi Silme Hatasý: "+e);
		}
		 model.addAttribute("ls", arazlistele());
		 System.out.println("arazýye gýtmeden once");
		 return "redirect:/admin/arazi";
	 }
	 
	 @RequestMapping(value="/arazi",method=RequestMethod.POST)
	 public String kaydet(Varazi vz, Model model) {
		 String durum="";
		 try {
			String query="insert into varazi (vaid,vabaslik,vaacik,vadetay,varesim,vafiyat)"
					+ " values (null,'"+vz.getVabaslik()+"', '"+vz.getVaacik()+"', '"+vz.getVadetay()+"',"
							+ "'"+vz.getVaresim()+"','"+vz.getVafiyat()+"')";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				durum="Ekleme Baþarýlý";
			}
			else {
				durum="Ekleme Baþarýsýz";
			}
		} catch (Exception e) {
			System.err.println("Arazi Ekleme Hatasý: "+e);
		}
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls", arazlistele());
		 return "redirect:/admin/arazi";
	 }
	 
	 public List arazlistele() {
			DB db = new DB();
			
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
					vz.setVaresim(rs.getString(""+VaraziEnum.varesim));
					vz.setVafiyat(rs.getString(""+VaraziEnum.vafiyat));
					ls.add(vz);
				}
			} catch (Exception e) {
				System.err.println("Arazi Gör Hatasý: "+e);
			}
		 return ls;
		 
	 }
	 
	 @RequestMapping(value="/araziduzenle/{id}" , method=RequestMethod.GET)
	 public String araziduzenle(Model model,@PathVariable(value="id")String id) {
		 Varazi vz = new Varazi();
		 try {
			
			String query="select * from varazi where vaid="+id;
			System.out.println(query);
			ResultSet rs = db.baglan().executeQuery(query);
			
				
				rs.next();
				vz.setVaid(rs.getString(""+VaraziEnum.vaid));
				vz.setVabaslik(rs.getString(""+VaraziEnum.vabaslik));
				vz.setVaacik(rs.getString(""+VaraziEnum.vaacik));
				vz.setVadetay(rs.getString(""+VaraziEnum.vadetay));
				vz.setVaresim(rs.getString(""+VaraziEnum.varesim));
				vz.setVafiyat(rs.getString(""+VaraziEnum.vafiyat));
			
		} catch (Exception e) {
			System.err.println("Düzenleme Hatasý: "+e);
		}
		 model.addAttribute("vz", vz);
		 model.addAttribute("id", "4");
		 model.addAttribute("ls", arazlistele());
		 return "admin/araziduzenle";
	 }
	 
	 @RequestMapping(value="/araziduzenle",method=RequestMethod.POST)
	 public String araziduzenle (Varazi vz, Model model) {

		 String id = vz.getVaid();
		 String durum="";
		 try {
			String query="update varazi set vabaslik='"+vz.getVabaslik()+"',"
					+ " vaacik='"+vz.getVaacik()+"', vadetay='"+vz.getVadetay()+"', "
							+ "varesim='"+vz.getVaresim()+"', vafiyat='"+vz.getVafiyat()+"' where vaid='"+id+"'";
			System.out.println(query);
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				System.out.println("Arazi Düzenleme ekleme baþarýlý");
				durum="Düzenle Ekle Baþarýlý";
				return "redirect:/admin/arazi";
			}
			else {
				durum="Düzenle Ekle Baþarýlý Deðil !";
			}
		} catch (Exception e) {
			System.err.println("Arazi Düzenle-Ekle Hatasý: "+e);
		}
		 model.addAttribute("vvz", vz);
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls",arazlistele());
	
		 return "redirect:/admin/arazi";
	 }
}
