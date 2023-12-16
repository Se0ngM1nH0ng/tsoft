package com.example.test5.model;

public interface InterfaceMemberService {
    MemberDTO selectOne(MemberDTO mDTO);
    MemberDTO selectOne_login(MemberDTO mDTO);
    boolean insert(MemberDTO mDTO);
    boolean update(String username, String role);

    boolean update(MemberDTO mDTO);
}
