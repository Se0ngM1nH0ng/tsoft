package com.example.biz.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InterfaceMemberDAO {
    List<MemberDTO> selectAll();
    boolean insert(Map<String, Object> map); // 인자가 2개이상이라 map 컬레션 사용

    MemberDTO selectOne(String mid);

    MemberDTO selectOne_login(Map<String , Object> map);


    boolean update(Map<String, Object> map);

    boolean delete(String mid);
}
