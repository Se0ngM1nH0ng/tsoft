package com.example.securitytest1.controller;

import com.example.securitytest1.dto.InterfaceMemberService;
import com.example.securitytest1.dto.MemberDTO;
import com.example.securitytest1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor

public class CTRL {

    private final MemberService memberService;


    @GetMapping("/")

    public String root(){

        return "main";
    }
    @PostMapping("/loginCheck")
    public String test(MemberDTO mDTO){

        mDTO = memberService.selectOne_login(mDTO);
        if(mDTO != null){
            return "loginSuccess";
        }
        else{
            return "main";
        }
    }


    @GetMapping("/user") // 사용자 페이지
    public String memberPage(){

        return "user";
    }

    @GetMapping("/admin") // 관리자 페이지
    public String adminPage(){

        return "admin";
    }
//
//    /**
//     * 유저 페이지
//     * @param model
//     * @param authentication
//     * @return
//     */
//    @GetMapping("/user_access")
//    public String userAccess(Model model, Authentication authentication) {
//        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
//        UserVo userVo = (UserVo) authentication.getPrincipal();  //userDetail 객체를 가져옴
//        model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님");      //유저 아이디
//        return "user_access";
//    }

}
