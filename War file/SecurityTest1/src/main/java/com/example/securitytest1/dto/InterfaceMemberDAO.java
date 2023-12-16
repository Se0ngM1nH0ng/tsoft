package com.example.securitytest1.dto;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface InterfaceMemberDAO {
    MemberDTO selectOne(String mid);
    MemberDTO selectOne_login(Map<String, Object> map);

}
