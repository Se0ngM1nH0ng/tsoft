package com.cos.security3.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRoleDTO {

    private int memberCode;
    private int authorityCode;
    private AuthorityDTO authority;

    public MemberRoleDTO(){

    }

    public MemberRoleDTO(int memberCode, int authorityCode){
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
    }

    public MemberRoleDTO(int memberCode, int authorityCode, AuthorityDTO authority){
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }
}
