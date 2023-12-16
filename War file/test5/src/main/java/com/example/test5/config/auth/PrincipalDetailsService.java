package com.example.test5.config.auth;

import com.example.test5.model.InterfaceMemberDAO;
import com.example.test5.model.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Security 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행이 된다. << 규칙 !
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    // Mapper 인터페이스
    private final InterfaceMemberDAO interfaceMemberDAO;

    // Security session = Authentication = UserDetails
    // UserDetails 가 Authentication 의 내부로 Authentication(내부 UserDetails)
    // Authentication 이 session 의 내부로 Security session(내부 Authentication(내부 UserDetails)) 요런 순서
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loginForm 에 username 과 맞춰줘야 한다 !!
        // 안맞을시 Security Config 에서 .usernameParameter("내가 지정한 값") 이라고 바꿔줘야 한다.
       MemberDTO mData = interfaceMemberDAO.findMyId(username);

        if(mData != null) {
            return new PrincipalDetails(mData); // 데이터를 보내준다.
        }

        return null;
    }
}
