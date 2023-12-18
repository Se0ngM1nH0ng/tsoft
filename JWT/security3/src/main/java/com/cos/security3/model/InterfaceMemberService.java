package com.cos.security3.model;

public interface InterfaceMemberService {
    MemberDTO selectOne(MemberDTO mDTO);
    TokenDTO selectOne_login(MemberDTO mDTO);
    boolean insert(MemberDTO mDTO);
    boolean update(String username, String role);
    Object check(String createToken);

}
