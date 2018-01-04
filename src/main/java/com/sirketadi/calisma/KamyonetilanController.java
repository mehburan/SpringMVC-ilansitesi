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
import Utils.Vkamyonet;
import Utils.VkamyonetEnum;

@Controller
public class KamyonetilanController {
	DB db = new DB();
	List<Vkamyonet> ls = new ArrayList<Vkamyonet>();
	List<UrunResim> uks = new ArrayList<UrunResim>();
	@RequestMapping(value="admin/kamyonilan/{id}")
	public String kamilan(Model model,@PathVariable(value="id")String id) {
		
		try {
			ls = new ArrayList<Vkamyonet>();
			String query="select *from vkamyonet";
			ResultSet rs = db.baglan().executeQuery(query);
			while(rs.next()) {
				Vkamyonet vk = new Vkamyonet();
				vk.setVkid(rs.getString(""+VkamyonetEnum.vkid));
				vk.setVkbaslik(rs.getString(""+VkamyonetEnum.vkbaslik));
				vk.setVkacik(rs.getString(""+VkamyonetEnum.vkacik));
				vk.setVkdetay(rs.getString(""+VkamyonetEnum.vkdetay));
				vk.setVkfiyat(rs.getString(""+VkamyonetEnum.vkfiyat));
				ls.add(vk);
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Site Hatasý: "+e);
		}
		try {
			uks = new ArrayList<UrunResim>();
				String query ="select *from urun_resimleri where urun_id=5";
				ResultSet urs = db.baglan().executeQuery(query);
				while(urs.next()) {
					UrunResim ur = new UrunResim();
					ur.setUadi(urs.getString(""+UrunResimEnum.adi));
					uks.add(ur);
					
				}
			} catch (Exception e) {
				System.err.println("Arazi Site Resim Hatasý: "+e);
			}
		for (Vkamyonet vkamyonet : ls) {
			if (vkamyonet.getVkid().equals(id)) {
				model.addAttribute("vkamyonet", vkamyonet);
				System.out.println("esitlik kontrolu:"+id);
				break;
			}
		}
			model.addAttribute("ls", ls);
			model.addAttribute("id", 5);
			model.addAttribute("uks", uks);
		
		return "admin/kamyonilan";
	}
}
