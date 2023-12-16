package com.cos.security3.controller;

import com.cos.security3.model.InterfaceMemberService;
import com.cos.security3.model.MemberDTO;
import com.cos.security3.model.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@AllArgsConstructor
public class IndexController {

    private final InterfaceMemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/") // 처음 기본 페이지
    public String defaultLoginForm(){
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm") // 로그인 페이지
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/index") // 성공시 페이지
    public String index(HttpSession session){
        // SecurityContextHolder에서 현재 인증된 사용자의 Authentication 객체를 가져옵니다.
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("auth 로그 : " + auth.toString());

        String username = auth.getName();
        System.out.println("username 로그 : " + username);
        session.setAttribute("username",username);

        return "index";
    }

    @GetMapping("/user") // 유저 페이지
    public String user(){
        return "user";
    }

    @GetMapping("/admin") // 관리자 페이지
    public String admin(){
        return "admin";
    }

    @GetMapping("/manager") // 매니저 페이지
    public String manager(){
        return "manager";
    }


    @GetMapping("/joinForm") // 회원가입 페이지
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join") // 회원가입 처리
    public String join(MemberDTO mDTO){
        System.out.println(mDTO);

        mDTO.setMRole("USER");
        String rawPassword = mDTO.getMPw();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        mDTO.setMPw(encPassword);
        memberService.insert(mDTO);

        return "redirect:/loginForm";
    }

    @PostMapping("/changeRole")
    @ResponseBody
    public String changeRole(@RequestBody Map<String, String> roleData, HttpSession session){
        String role = roleData.get("role");
        System.out.println("role 로그 : " + role);
        String username = (String) session.getAttribute("username");
        if (username != null && role != null) {
            memberService.update(username, role);
            return "success"; // 업데이트 성공 시 응답
        }
        return "fail"; // 업데이트 실패 시 응답
    }

    //@PostMapping("/login") // 중복 로직
//    public String login(MemberDTO mDTO, Model model){
//        System.out.println("로그 : " + mDTO);
//        MemberDTO mdata = memberService.selectOne_login(mDTO);
//        if(mdata != null){
//            model.addAttribute("mdata", mdata);
//            return "index";
//        }
//        else{
//            return "redirect:/loginForm";
//        }
//    }



//    @Secured("ADMIN") // 특정 한 개에만 권한을 걸고 싶을때 !
//    @GetMapping("/info")
//    public @ResponseBody String info(){
//        return "개인정보";
//    }


}
