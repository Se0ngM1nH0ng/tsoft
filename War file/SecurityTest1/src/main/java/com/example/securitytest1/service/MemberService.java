package com.example.securitytest1.service;

import com.example.securitytest1.dto.InterfaceMemberDAO;
import com.example.securitytest1.dto.InterfaceMemberService;
import com.example.securitytest1.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class MemberService implements InterfaceMemberService {

    private final InterfaceMemberDAO mDAO;

    @Override
    public MemberDTO selectOne(MemberDTO mDTO) {

        return mDAO.selectOne(mDTO.getMId());
    }

    @Override
    public MemberDTO selectOne_login(MemberDTO mDTO) {
        Map<String , Object> map = new HashMap<String, Object>();
        map.put("data1", mDTO.getMId());
        map.put("data2", mDTO.getMPw());
        return mDAO.selectOne_login(map);
    }
}
