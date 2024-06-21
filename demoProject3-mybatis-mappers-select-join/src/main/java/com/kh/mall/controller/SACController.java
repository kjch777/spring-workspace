package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kh.mall.dto.SAC;
import com.kh.mall.service.SACService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SACController {

	@Autowired
	private SACService sacService;

	@GetMapping("/") // index.html 의 기본 주소는 / 이다.
	// 따로 특정한 기능을 넣지 않았다면, / 가 index 를 가리키기 때문에 작성을 생략해도 되지만
	// 특정 값을 가져오거나, / 가 index 이외에 다른 html 파일을 가리키게 하려면
	// @GetMpping("여기에 기능이나 html 파일을 작성해주면 된다.")
	public String getAllSAC(Model model) {
		List<SAC> sac = sacService.getAllSAC();

		log.info("DB 값 제대로 가져오는지 확인" + sac);
		/*
		 * dto 에서 @ToString 을 사용하지 않으면, DB 에서 가져오는 주소 값만 보여지기 때문에 값을 제대로 가져 왔는지 확인하고 싶다면
		 * dto 에 @ToString 을 추가해주어야 한다. 만약, 값을 제대로 가져오지 못했다면 null 이 출력된다.
		 */
		model.addAttribute("snackAndCompany", sac);
		return "index";
	}

	@GetMapping("/snack/{snack_id}") // 주소값(URL) 이 변할 때는, 변하는 변수를 중괄호 { } 로 감싸준다.

	// 주소값으로 id 숫자 값을 가져와서, 주소값에 지정된 id 숫자 값과 일치하는 DB 값을 모두 가져오기
	public String getSnackById(Model model, @PathVariable int snack_id) {

		// 주소값으로 설정한 id 를 받아오고, sacService 에 전달하여 DB 에서 가져오기
		SAC sac = sacService.getSnackById(snack_id);
		model.addAttribute("snack", sac);
		// snackDetail.html 파일에서
		// th:text="${snack.snack_name}" 으로 미리 작성해 두었기 때문에,
		// 여기서도 model.addAttribute("snack" 으로 작성해 주어야 한다, sac 는 여기서의 코드와 같다);

		return "snackDetail";
	}

	@GetMapping("/company/{company_id}") // 주소값(URL) 이 변할 때는, 변하는 변수를 중괄호 { } 로 감싸준다.

	// 주소값으로 id 숫자 값을 가져와서, 주소값에 지정된 id 숫자 값과 일치하는 DB 값을 모두 가져오기
	public String getCompanyById(Model model, @PathVariable int company_id) {

		// 주소값으로 설정한 id 를 받아오고, sacService 에 전달하여 DB 에서 가져오기
		SAC sac = sacService.getCompanyById(company_id);
		
		log.info("확인: " + sac);
		
		model.addAttribute("company", sac);

		return "companyDetail";
	}
}
