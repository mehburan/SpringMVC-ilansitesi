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
import Utils.Ekiralik;
import Utils.EkiralikEnum;
import Utils.UrunResim;
import Utils.UrunResimEnum;

@Controller
public class KiralikController {
	DB db = new DB();
	@RequestMapping(value="admin/kiralik")
	public String kiraGor(Model model) {
		List<UrunResim> ulk = new ArrayList<UrunResim>();
		try {
			String kadi="";
			String query="select *from urun_resimleri where urun_id=2";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(rs.getString("" + UrunResimEnum.adi));
				kadi=ur.getUadi();
				ulk.add(ur);
				System.out.println(ur.getUadi());
				model.addAttribute("kadi", kadi);
			}
		} catch (Exception e) {
			System.err.println("Kira Gör Hatasý : "+e);
		}
		model.addAttribute("id","2");
		model.addAttribute("ulk", ulk);
		model.addAttribute("ls", kiralistele());
		return "admin/kiralik";
	}
	
	 @RequestMapping(value="kiralik/sil/{id}")
	 public String kirasil(@PathVariable(value="id")String id, Model model) {
		 try {
			 System.out.println("delete controller");
			String query="delete from ekiralik where ekid='"+id+"'";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				return "redirect:/admin/kiralik";
			}
		} catch (Exception e) {
			System.err.println("Kiralýk Silme Hatasý: "+e);
		}
		 model.addAttribute("ls", kiralistele());
		 
		 return "redirect:/admin/kiralik";
	 }
	 
	 @RequestMapping(value="/kiralik",method=RequestMethod.POST)
	 public String kirakaydet(Ekiralik ek, Model model) {
		 String durum="";
		 try {
			String query="insert into ekiralik (ekid,ekbaslik,ekacik,ekdetay,ekresim,ekfiyat)"
					+ " values (null,'"+ek.getEkbaslik()+"', '"+ek.getEkacik()+"', '"+ek.getEkdetay()+"',"
							+ "'"+ek.getEkresim()+"','"+ek.getEkfiyat()+"')";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				durum="Ekleme Baþarýlý";
			}
			else {
				durum="Ekleme Baþarýsýz";
			}
		} catch (Exception e) {
			System.err.println("Kiralýk Ekleme Hatasý: "+e);
		}
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls", kiralistele());
		 return "redirect:/admin/kiralik";
	 }
	 
	 public List kiralistele() {
			DB db = new DB();
			
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
					ek.setEkresim(rs.getString(""+EkiralikEnum.ekresim));
					ek.setEkfiyat(rs.getString(""+EkiralikEnum.ekfiyat));
					ls.add(ek);
				}
			} catch (Exception e) {
				System.err.println("Kira Gör Hatasý: "+e);
			}
		 return ls;
		 
	 }
	 
	 @RequestMapping(value="/kiraduzenle/{id}" , method=RequestMethod.GET)
	 public String kiraduzenleme(Model model,@PathVariable(value="id")String id) {
		 Ekiralik ek = new Ekiralik();
		 try {
			
			String query="select * from ekiralik where ekid="+id;
			System.out.println(query);
			ResultSet rs = db.baglan().executeQuery(query);
			
				
				rs.next();
				ek.setEkid(rs.getString(""+EkiralikEnum.ekid));
				System.out.println("Ben kiralýk düzenle getir methouyum");
				ek.setEkbaslik(rs.getString(""+EkiralikEnum.ekbaslik));
				ek.setEkacik(rs.getString(""+EkiralikEnum.ekacik));
				ek.setEkdetay(rs.getString(""+EkiralikEnum.ekdetay));
				ek.setEkresim(rs.getString(""+EkiralikEnum.ekresim));
				ek.setEkfiyat(rs.getString(""+EkiralikEnum.ekfiyat));
			
		} catch (Exception e) {
			System.err.println("Düzenleme Hatasý: "+e);
		}
		 model.addAttribute("ek", ek);
		 model.addAttribute("id", "2");
		 model.addAttribute("ls", kiralistele());
		 return "admin/kiraduzenle";
	 }
	 
	 @RequestMapping(value="/kiraduzenle",method=RequestMethod.POST)
	 public String kiraduzenle (Ekiralik ek, Model model) {

		 String id = ek.getEkid();
		 String durum="";
		 try {
			String query="update ekiralik set ekbaslik='"+ek.getEkbaslik()+"',"
					+ " ekacik='"+ek.getEkacik()+"', ekdetay='"+ek.getEkdetay()+"', "
							+ "ekresim='"+ek.getEkresim()+"', ekfiyat='"+ek.getEkfiyat()+"' where ekid='"+id+"'";
			System.out.println(query);
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				System.out.println("Kiralýk Düzenleme ekleme baþarýlý");
				durum="Düzenle Ekle Baþarýlý";
				return "redirect:/admin/kiralik";
			}
			else {
				durum="Düzenle Ekle Baþarýlý Deðil !";
				System.out.println(durum);
			}
		} catch (Exception e) {
			System.err.println("Kiralýk Düzenle-Ekle Hatasý: "+e);
		}
		 model.addAttribute("es", ek);
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls",kiralistele());
	
		 return "redirect:/admin/kiralik";
	 }
}