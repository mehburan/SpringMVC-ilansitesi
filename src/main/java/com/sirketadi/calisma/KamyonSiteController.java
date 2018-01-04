package com.sirketadi.calisma;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Utils.DB;
import Utils.UrunResim;
import Utils.UrunResimEnum;
import Utils.Vkamyonet;
import Utils.VkamyonetEnum;

@Controller
public class KamyonSiteController {
	DB db = new DB();
	@RequestMapping(value="/kamyonsite")
	public String kamsite(Model model) {
		List<UrunResim> us = new ArrayList<UrunResim>();
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
				vk.setVkfiyat(rs.getString(""+VkamyonetEnum.vkfiyat));
				ls.add(vk);
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Site Hatasý: "+e);
		}
		try {
			
			String query ="select *from urun_resimleri where urun_id=5";
			ResultSet urs = db.baglan().executeQuery(query);
			while(urs.next()) {
				UrunResim ur = new UrunResim();
				ur.setUadi(urs.getString(""+UrunResimEnum.adi));
				us.add(ur);
				
			}
		} catch (Exception e) {
			System.err.println("Kamyonet Site Resim Hatasý: "+e);
		}
		model.addAttribute("ls", ls);
		model.addAttribute("id", 5);
		model.addAttribute("us", us.get(0).getUadi());
	
		return "admin/kamyonsite";
	}
}
