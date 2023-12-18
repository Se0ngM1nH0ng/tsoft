package com.cos.security3.config.auth;

import com.cos.security3.model.AuthorityDTO;
import com.cos.security3.model.InterfaceMemberDAO;
import com.cos.security3.model.MemberDTO;
import com.cos.security3.model.MemberRoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        List<MemberRoleDTO> memberRoleList = interfaceMemberDAO.getAuthList(mData.getMCode());
        for(MemberRoleDTO mRole : memberRoleList){
            AuthorityDTO auth = interfaceMemberDAO.findAuth(mRole.getAuthorityCode());
            mRole.setAuthority(auth);
        }
        mData.setMRole(memberRoleList);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(MemberRoleDTO mRole : mData.getMRole()){
            String authorityName = mRole.getAuthority().getAuthorityName();
            authorities.add(new SimpleGrantedAuthority(authorityName));
            mData.setAuthorities(authorities);
        }

        return mData;
    }
}
