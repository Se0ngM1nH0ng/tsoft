package com.cos.security3.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InterfaceMemberDAO {
    MemberDTO selectOne(String mid);
    MemberDTO selectOne_login(Map<String, Object> map);
    boolean insert(Map<String , Object> map);
    boolean update(Map<String, Object> map);
    MemberDTO findMyId(String id);
    int getSequence();
    void insertAuth(int mCode, int auth);
    List<MemberRoleDTO> getAuthList(int mCode);
    AuthorityDTO findAuth (int authorityCode);
    void refreshToken(Map<String, Object> map);
    int check(String createToken);
    String findToken(String name);
}
