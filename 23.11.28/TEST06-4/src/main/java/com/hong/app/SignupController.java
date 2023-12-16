package com.hong.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignupController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String root() {
		return "signup";
	}
	
	
	
	@PostMapping("/signupCheck")
	@ResponseBody
	public String signupCheck(@RequestParam("mid")String mid, MemberDTO mDTO) {
		
		mDTO.setSk("SIGN");
		String msg = "";
		try {
		    MemberDTO signupMidCheck = memberService.selectOne(mDTO);
		    if (signupMidCheck == null) {
		        msg = "true";
		    }else { 
		        msg = "false";
		    }
		} catch (EmptyResultDataAccessException e) {
		    // DB에서 결과가 비어있을 때 발생하는 예외 처리
		    // 로그를 출력하거나 다른 처리를 수행할 수 있습니다.
		    e.printStackTrace(); // 혹은 로그 출력
		    msg = "false"; // 예외 발생 시 기본적으로 false로 처리하거나 다른 로직 추가
		}
		return msg; // t/f 인지 
	}

}
