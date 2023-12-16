package com.hong.app;

import lombok.Data;

@Data // lombok @annotation
public class MemberDTO {
	private String mid; // 아이디 
	private String mpw; // 비밀번호
	private String sk; // Search Keyword
}
