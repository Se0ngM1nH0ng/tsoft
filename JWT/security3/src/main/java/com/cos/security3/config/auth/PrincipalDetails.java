package com.cos.security3.config.auth;

// 시큐리티가 /login 주소요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료가 되면 시큐리티가 가진 session 을 만들어준다. (Security ContextHolder 라는 key 값을 가진 )
// Security가 가지고 있는 세션에 들어갈수 있는 오브젝트는 정해져있다 ==> Authentication 타입 객체
// Authentication 객체 안에는 뭐가 있냐면 ? ==> User 정보가 있어야 한다.
// User 오브젝트 타입 => UserDetails 타입 객체

// Security Session 영역 => 들어갈수 있는 객체 Authentication => 여기 안에 UserDetails(PrincipalDetails) 라는 타입이 있다

// 그렇다면 UserDetails는 어떻게 꺼낼까 ?
// 이렇게 되면 PrincipalDetails 라는 객체를 Authentication 객체 안에 넣을 수 있다.

import com.cos.security3.model.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {

    private final MemberDTO mDTO;


    // 해당 User의 권한을 리턴하는 곳 !
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // mDTO.getMRole() << 결국 얘 이지만 String 타입이라 반환 해줄수 없다
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() { // () 괄호 안은 GrantedAuthority 타입을 넣어줘야 하는데
            @Override
            public String getAuthority() { // 오버라이딩
                return "ROLE_"+mDTO.getMRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return mDTO.getMPw();
    }

    @Override
    public String getUsername() {
        return mDTO.getMId();
    }

    @Override
    public boolean isAccountNonExpired() { // 이 계정 만료 됐니 ?
        return true; // 아니오
    }

    @Override
    public boolean isAccountNonLocked() { // 이 계정 잠겼니 ?
        return true; // 아니오
    }

    @Override
    public boolean isCredentialsNonExpired() { // 너의 비밀번호가 만료됐니 ? 오래 사용했니 ?
        return true;
    }

    @Override
    public boolean isEnabled() { // 너 계정이 사용가능 하니 ?
        return true; // 사용 가능해
    }

    // 예를 들어 우리 사이트 에서 1 년동안 회원이 로그인을 안하면 휴먼계정으로 하기로 했다.
    // 로그인 했던 날짜를 DTO에 추가하면 현재 시간 - 로그인시간 => 1년을 초과시 return false ! 이런식으로 휴먼 전환
}
