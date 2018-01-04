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
import Utils.Votomobil;
import Utils.VotomobilEnum;

@Controller
public class OtomobilController {
	DB db = new DB();
	@RequestMapping(value="admin/otomobil")
	public String otoGor(Model model) {
		List<UrunResim> uos = new ArrayList<UrunResim>();
		try {
			String adi="";
			String query = "select *from urun_resimleri where urun_id=3";
			ResultSet rs = db.baglan().executeQuery(query);
			while (rs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(rs.getString("" + UrunResimEnum.adi));
				adi=ur.getUadi();
				uos.add(ur);
				System.out.println(ur.getUadi());
				model.addAttribute("adi", adi);
			}
		} catch (Exception e) {
			System.err.println("Arazi Resim Getirme Hatasý: " + e);
		}
		
		model.addAttribute("uos", uos);
		model.addAttribute("id", "3");
		model.addAttribute("ls", otolistele());
		return "admin/otomobil";
	}
	
	 @RequestMapping(value="otomobil/sil/{id}")
	 public String otosil(@PathVariable(value="id")String id, Model model) {
		 try {
			 System.out.println("delete controller");
			String query="delete from votomobil where voidd='"+id+"'";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				return "redirect:/admin/otomobil";
			}
		} catch (Exception e) {
			System.err.println("Otomobil Silme Hatasý: "+e);
		}
		 model.addAttribute("ls", otolistele());
		
		 return "redirect:/admin/otomobil";
	 }
	 
	 @RequestMapping(value="/otomobil",method=RequestMethod.POST)
	 public String kaydet(Votomobil vo, Model model) {
		 String durum="";
		 try {
			String query="insert into votomobil (voidd,vobaslik,voacik,vodetay,voresim,vofiyat)"
					+ " values (null,'"+vo.getVobaslik()+"', '"+vo.getVoacik()+"', '"+vo.getVodetay()+"',"
							+ "'"+vo.getVoresim()+"','"+vo.getVofiyat()+"')";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				durum="Ekleme Baþarýlý";
			}
			else {
				durum="Ekleme Baþarýsýz";
			}
		} catch (Exception e) {
			System.err.println("Otomobil Ekleme Hatasý: "+e);
		}
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls", otolistele());
		 return "redirect:/admin/otomobil";
	 }
	 
	 public List otolistele() {
			DB db = new DB();
			
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
					vo.setVoresim(rs.getString(""+VotomobilEnum.voresim));
					vo.setVofiyat(rs.getString(""+VotomobilEnum.vofiyat));
					ls.add(vo);
				}
			} catch (Exception e) {
				System.err.println("Oto Gör Hatasý: "+e);
			}
		 return ls;
		 
	 }
	 
	 @RequestMapping(value="/otoduzenle/{id}" , method=RequestMethod.GET)
	 public String otoduzenle(Model model,@PathVariable(value="id")String id) {
		 Votomobil vo = new Votomobil();
		 try {
			
			String query="select * from votomobil where voidd="+id;
			System.out.println(query);
			ResultSet rs = db.baglan().executeQuery(query);
			
				
				rs.next();
				vo.setVoidd(rs.getString(""+VotomobilEnum.voidd));
				vo.setVobaslik(rs.getString(""+VotomobilEnum.vobaslik));
				vo.setVoacik(rs.getString(""+VotomobilEnum.voacik));
				vo.setVodetay(rs.getString(""+VotomobilEnum.vodetay));
				vo.setVoresim(rs.getString(""+VotomobilEnum.voresim));
				vo.setVofiyat(rs.getString(""+VotomobilEnum.vofiyat));
			
		} catch (Exception e) {
			System.err.println("Düzenleme Hatasý: "+e);
		}
		 model.addAttribute("vo", vo);
		 model.addAttribute("id", "3");
		 model.addAttribute("ls", otolistele());
		 return "admin/otoduzenle";
	 }
	 
	 @RequestMapping(value="/otoduzenle",method=RequestMethod.POST)
	 public String otoduzenle (Votomobil vo, Model model) {

		 String id = vo.getVoidd();
		 String durum="";
		 try {
			String query="update votomobil set vobaslik='"+vo.getVobaslik()+"',"
					+ " voacik='"+vo.getVoacik()+"', vodetay='"+vo.getVodetay()+"', "
							+ "voresim='"+vo.getVoresim()+"', vofiyat='"+vo.getVofiyat()+"' where voidd='"+id+"'";
			System.out.println(query);
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				System.out.println("Oto Düzenleme ekleme baþarýlý");
				durum="Düzenle Ekle Baþarýlý";
				return "redirect:/admin/otomobil";
			}
			else {
				durum="Düzenle Ekle Baþarýlý Deðil !";
			}
		} catch (Exception e) {
			System.err.println("Oto Düzenle-Ekle Hatasý: "+e);
		}
		 model.addAttribute("vo", vo);
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls",otolistele());
	
		 return "redirect:/admin/otomobil";
	 }
}
