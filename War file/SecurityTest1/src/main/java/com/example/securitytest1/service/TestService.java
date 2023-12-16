//package com.example.securitytest1.service;
//
//import com.example.securitytest1.dto.MemberDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.yaml.snakeyaml.events.Event;
//
//import java.lang.reflect.Member;
//
//@Service
//@RequiredArgsConstructor
//public class TestService {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public void register(String id, String mpw){
//        String encodePassword = passwordEncoder.encode(mpw);
//        MemberDTO member = new MemberDTO(id, encodePassword);
//
//        TestRepository.save(member);
//
//    }
//
//    public boolean login(String mid, String mpw){
//        Member member = TestRepository.find(id);
//        if(passwordEncoder.matches(mpw, ))
//
//    }
//}
