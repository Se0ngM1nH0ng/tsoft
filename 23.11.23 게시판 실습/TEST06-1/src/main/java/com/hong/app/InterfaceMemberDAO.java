package com.hong.app;

import java.util.List;

public interface InterfaceMemberDAO {
	public boolean insert(MemberDTO mDTO);
	public boolean update(MemberDTO mDTO);
	public boolean delete(MemberDTO mDTO);
	public List<MemberDTO> selectAll(MemberDTO mDTO);
	public MemberDTO selectOne(MemberDTO mDTO);
}
