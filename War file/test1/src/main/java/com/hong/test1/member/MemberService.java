package com.hong.test1.member;

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
        return mDAO.selectOne(mDTO.getMid());
    }
    @Override
    public MemberDTO selectOne_login(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1", mDTO.getMid());
        map.put("data2", mDTO.getMpw());
        return mDAO.selectOne_login(map);
    }

    @Override
    public boolean insert(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", mDTO.getMid()); // 첫번째
        map.put("data2", mDTO.getMpw()); // 두번째
        map.put("data3", mDTO.getMname()); // 두번째
        return mDAO.insert(map);
    }

    @Override
    public boolean update(MemberDTO mDTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data1", mDTO.getMpw()); // 첫번째
        map.put("data2", mDTO.getMid()); // 두번째
        return mDAO.update(map);
    }

    @Override
    public boolean delete(MemberDTO mDTO) {

        return mDAO.delete(mDTO.getMid()); // param 인자 방식
    }
}
