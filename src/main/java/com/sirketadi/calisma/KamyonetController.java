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
import Utils.Vkamyonet;
import Utils.VkamyonetEnum;
import Utils.Votomobil;

@Controller
public class KamyonetController {
	DB db = new DB();
	@RequestMapping(value="admin/kamyonet")
	public String kamGor(Model model) {
		List<UrunResim> uok = new ArrayList<UrunResim>();
		try {
			String adi="";
			String query = "select *from urun_resimleri where urun_id=5";
			ResultSet rs = db.baglan().executeQuery(query);
			while (rs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(rs.getString("" + UrunResimEnum.adi));
				adi=ur.getUadi();
				uok.add(ur);
				System.out.println(ur.getUadi());
				model.addAttribute("adi", adi);
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Resim Getirme Hatasý: " + e);
		}
		
		model.addAttribute("uok", uok);
		model.addAttribute("id", "5");
		model.addAttribute("ls", kamlistele());
		return "admin/kamyonet";
	}
	
	 @RequestMapping(value="kamyonet/sil/{id}")
	 public String kamsil(@PathVariable(value="id")String id, Model model) {
		 try {
			 System.out.println("delete controller");
			String query="delete from vkamyonet where vkid='"+id+"'";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				return "redirect:/admin/kamyonet";
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Silme Hatasý: "+e);
		}
		 model.addAttribute("ls", kamlistele());
		
		 return "redirect:/admin/kamyonet";
	 }
	 
	 @RequestMapping(value="/kamyonet",method=RequestMethod.POST)
	 public String kamkaydet(Vkamyonet vk, Model model) {
		 String durum="";
		 try {
			String query="insert into vkamyonet (vkid,vkbaslik,vkacik,vkdetay,vkresim,vkfiyat)"
					+ " values (null,'"+vk.getVkbaslik()+"', '"+vk.getVkacik()+"', '"+vk.getVkdetay()+"',"
							+ "'"+vk.getVkresim()+"','"+vk.getVkfiyat()+"')";
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				durum="Ekleme Baþarýlý";
			}
			else {
				durum="Ekleme Baþarýsýz";
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Ekleme Hatasý: "+e);
		}
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls", kamlistele());
		 return "redirect:/admin/kamyonet";
	 }
	 
	 public List kamlistele() {
			DB db = new DB();
			
			List<Vkamyonet> ls = new ArrayList<Vkamyonet>();
		 try {
				String query="select *from vkamyonet";
				ResultSet rs = db.baglan().executeQuery(query);
				while(rs.next()) {
					Vkamyonet vk = new Vkamyonet();
					vk.setVkid(rs.getString(""+VkamyonetEnum.vkid));
					vk.setVkbaslik(rs.getString(""+VkamyonetEnum.vkbaslik));
					vk.setVkacik(rs.getString(""+VkamyonetEnum.vkacik));
					vk.setVkdetay(rs.getString(""+VkamyonetEnum.vkdetay));
					vk.setVkresim(rs.getString(""+VkamyonetEnum.vkresim));
					vk.setVkfiyat(rs.getString(""+VkamyonetEnum.vkfiyat));
					ls.add(vk);
				}
			} catch (Exception e) {
				System.err.println("Kamyonet Gör Hatasý: "+e);
			}
		 return ls;
		 
	 }
	 
	 @RequestMapping(value="/kamduzenle/{id}" , method=RequestMethod.GET)
	 public String kamduzenle(Model model,@PathVariable(value="id")String id) {
		 Vkamyonet vk = new Vkamyonet();
		 try {
			
			String query="select * from vkamyonet where vkid="+id;
			System.out.println(query);
			ResultSet rs = db.baglan().executeQuery(query);
			
				
				rs.next();
				vk.setVkid(rs.getString(""+VkamyonetEnum.vkid));
				vk.setVkbaslik(rs.getString(""+VkamyonetEnum.vkbaslik));
				vk.setVkacik(rs.getString(""+VkamyonetEnum.vkacik));
				vk.setVkdetay(rs.getString(""+VkamyonetEnum.vkdetay));
				vk.setVkresim(rs.getString(""+VkamyonetEnum.vkresim));
				vk.setVkfiyat(rs.getString(""+VkamyonetEnum.vkfiyat));
			
		} catch (Exception e) {
			System.err.println("Düzenleme Hatasý: "+e);
		}
		 model.addAttribute("vk", vk);
		 model.addAttribute("id", "5");
		 model.addAttribute("ls", kamlistele());
		 return "admin/kamduzenle";
	 }
	 
	 @RequestMapping(value="/kamduzenle",method=RequestMethod.POST)
	 public String otoduzenle (Vkamyonet vk, Model model) {

		 String id = vk.getVkid();
		 String durum="";
		 try {
			String query="update vkamyonet set vkbaslik='"+vk.getVkbaslik()+"',"
					+ " vkacik='"+vk.getVkacik()+"', vkdetay='"+vk.getVkdetay()+"', "
							+ "vkresim='"+vk.getVkresim()+"', vkfiyat='"+vk.getVkfiyat()+"' where vkid='"+id+"'";
			System.out.println(query);
			int deger=db.baglan().executeUpdate(query);
			if(deger>0) {
				System.out.println("Kamyonet Düzenleme ekleme baþarýlý");
				durum="Düzenle Ekle Baþarýlý";
				return "redirect:/admin/kamyonet";
			}
			else {
				durum=" Kamyonet Düzenle Ekle Baþarýlý Deðil !";
			}
		} catch (Exception e) {
			System.err.println("Kamyon Düzenle-Ekle Hatasý: "+e);
		}
		 model.addAttribute("vk", vk);
		 model.addAttribute("durum", durum);
		 model.addAttribute("ls",kamlistele());
	
		 return "redirect:/admin/kamyonet";
	 }
}
