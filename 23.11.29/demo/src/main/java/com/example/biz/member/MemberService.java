package com.example.biz.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class MemberService implements InterfaceMemberService{

    private final InterfaceMemberDAO mDAO;

    @Override
    public List<MemberDTO> selectAll() {
        return mDAO.selectAll();
    }

    @Override
    public MemberDTO selectOne(MemberDTO mDTO) {
        return mDAO.selectOne(mDTO.getMId());
    }
    @Override
    public MemberDTO selectOne_login(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1", mDTO.getMId());
        map.put("data2", mDTO.getMPw());
        return mDAO.selectOne_login(map);
    }

    @Override
    public boolean insert(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", mDTO.getMId()); // 첫번째
        map.put("data2", mDTO.getMPw()); // 두번째
        map.put("data3", mDTO.getMName()); // 두번째
        return mDAO.insert(map);
    }

    @Override
    public boolean update(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", mDTO.getMPw()); // 첫번째
        map.put("data2", mDTO.getMId()); // 두번째
        return mDAO.update(map);
    }

    @Override
    public boolean delete(MemberDTO mDTO) {
        return mDAO.delete(mDTO.getMId()); // param 인자 방식
    }
}
