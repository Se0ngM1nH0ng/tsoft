package com.cos.security3.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class MemberService implements InterfaceMemberService {
    private final InterfaceMemberDAO mDAO;


    public MemberDTO selectOne(MemberDTO mDTO) {

        return mDAO.selectOne(mDTO.getMId());
    }

    public MemberDTO selectOne_login(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1", mDTO.getMId());
        map.put("data2", mDTO.getMPw());
        return mDAO.selectOne_login(map);
    }

    public boolean insert(MemberDTO mDTO){
        Map<String, Object> map = new HashMap<>();
        map.put("data1", mDTO.getMId());
        map.put("data2", mDTO.getMPw());
        map.put("data3", mDTO.getMName());
        map.put("data4", mDTO.getMRole());

        return mDAO.insert(map);
    }

    @Override
    public boolean update(String username, String role) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1",role);
        map.put("data2",username);
        return mDAO.update(map);
    }


}
