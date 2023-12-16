package com.example.securitytest1.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class MemberDTO  { // implements UserDetails
    private String mId;
    private String mPw;
    private String mName;
//    private String authority;
//    private String name;
//    private int enabled;

    // 앱 사용자가 수행할 수 있는 작업을 GrantedAuthority 인스턴스의 컬렉션으로 반환
    // 사용자에게 부여된 그룹을 반환
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//        authList.add(new SimpleGrantedAuthority(authority));
//        return authList;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.mPw;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.mId;
//    }
//
//    @Override
//    public String getUsername() {
//        return mId;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled==1?true:false;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
