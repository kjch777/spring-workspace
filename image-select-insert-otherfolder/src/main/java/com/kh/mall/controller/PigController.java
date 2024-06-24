package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.dto.Pig;
import com.kh.mall.service.PigService;

public class PigController {

	@Autowired
	private PigService pigService;
	
	@GetMapping("/pig-all-list")
	public String getAllPigs(Model model) {
		List<Pig> pigList = pigService.getAllPigs();
		model.addAttribute("pigs", pigList);
		return "pigAllList";
	}
	
	@GetMapping("/pig_detail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig", pig);
		return "pigDetail";
	}
	
	@GetMapping("/pig-image-upload")
	public String upLoadPig(Model model) {
		model.addAttribute("p", new Pig());
		return "imgUpload";
	}
	
	@PostMapping("/upLoadPig")
	public String upLoadPig(@RequestParam ("pig_name") String pig_name,
							@RequestParam ("pig_age") int pig_age,
							@RequestParam ("pig_image_path") MultipartFile file, 
							Model model) {
		pigService.upLoadPig(pig_name, pig_age, file);
		
		return "redirect:/pig-all-list";
		// 업로드 완료 후, 이동하고자 하는 경로를 작성해준다.
	}
}
