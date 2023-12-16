package com.example.securitytest1.service;

import com.example.securitytest1.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
//@RequiredArgsConstructor
//public class UserDetailSeviceImpl implements UserDetails {
//    private final User user;
//
//    public UserDetailSeviceImpl(User user) {
//        this.user = user;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        MemberDTO member = memberRepository.(email).orElseThrow(() -> new UsernameNotFoundException("이메일이 존재하지 않습니다."));
//
//        return toUserDetails(member);
//    }
//
//    private UserDetails toUserDetails(Member member) {
//        return User.builder()
//                .username()
//                .password(member.getPassword())
//                .authorities(new SimpleGrantedAuthority(member.getRole().toString()))
//                .build();
//    }
//}
