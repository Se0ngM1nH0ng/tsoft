package com.example.biz.order;

import com.example.biz.member.MemberDTO;

import java.util.List;

public interface InterfaceOrderService {
    List<MemberDTO> selectAll();
    MemberDTO selectOne(MemberDTO mDTO);
    MemberDTO selectOne_login(MemberDTO mDTO);

    boolean insert(MemberDTO mDTO);
    boolean update(MemberDTO mDTO);
    boolean delete(MemberDTO mDTO);
}
