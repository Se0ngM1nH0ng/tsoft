package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements InterfaceMemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String INSERT = "INSERT INTO MEMBER (MID, MPW) VALUES (?,?)";
	//private final String UPDATE = "";
	//private final String DELETE = "";
	private final String SELECTALL = "SELECT MID,MPW FROM MEMBER";
	private final String SELECTONE_SIGNUP = "SELECT MID,MPW FROM MEMBER WHERE MID=?";
	private final String SELECTONE_LOGIN = "SELECT MID,MPW FROM MEMBER WHERE MID=? AND MPW=?";
	
	
	@Override
	public boolean insert(MemberDTO mDTO) {
		int rs =jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getMpw());
		if(rs<=0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		return true;
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return true;
	}

	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		
		return jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		try {
			if(mDTO.getSk().equals("LOGIN")) {
			Object[] args= {mDTO.getMid(), mDTO.getMpw()};
			return jdbcTemplate.queryForObject(SELECTONE_LOGIN, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}else if(mDTO.getSk().equals("SIGNUP")) {
			Object[] args= {mDTO.getMid()};
			return jdbcTemplate.queryForObject(SELECTONE_SIGNUP, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	return null;
	}
	
	
}
