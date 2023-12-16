package com.example.biz.member;

import java.util.List;

public interface InterfaceMemberService {
    List<MemberDTO> selectAll();
    MemberDTO selectOne(MemberDTO mDTO);
    MemberDTO selectOne_login(MemberDTO mDTO);

    boolean insert(MemberDTO mDTO);
    boolean update(MemberDTO mDTO);
    boolean delete(MemberDTO mDTO);
}
