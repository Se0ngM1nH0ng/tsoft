package com.example.biz.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final InterfaceMemberService memberService; // 의존주입

    @PostMapping(value = "/signup")
    public ResponseEntity<?> signup(@RequestBody MemberDTO mDTO) { // 회원 가입 정보 기입 후 성공 실패

        System.out.println(mDTO);

        // 서치 키워드 작성
        String msg = "";
        MemberDTO mdata = memberService.selectOne(mDTO); // 중복검사
        if (mdata == null) { // 다른 중복되는 아이디가 없다면
            msg = "true";
            memberService.insert(mDTO);
            return ResponseEntity.ok().body(HttpStatus.CREATED);
        } else {
            msg = "false";
            return ResponseEntity.ok().body(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list()  {
        List<MemberDTO> memberList = memberService.selectAll();

        return ResponseEntity.ok().body(memberList);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO mDTO){
        MemberDTO mLogin = memberService.selectOne_login(mDTO);
        System.out.println("로그 : " + mLogin );
        if(mLogin != null){
            System.out.println("로그2 : " + mLogin );
            return ResponseEntity.ok().body("로그인 성공");
        } else{
            return ResponseEntity.ok().body("로그인 실패");
        }
    }

}
