package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService  {

	@Autowired
	private InterfaceMemberDAO mDAO;
	
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return mDAO.selectAll(mDTO);
	}

	public MemberDTO selectOne(MemberDTO mDTO) {
		return mDAO.selectOne(mDTO);
	}

	public boolean insert(MemberDTO mDTO) {
		return mDAO.insert(mDTO);
	}

	public boolean update(MemberDTO mDTO) {
		return mDAO.update(mDTO);
	}

	public boolean delete(MemberDTO mDTO) {
		return mDAO.delete(mDTO);
	}

}
