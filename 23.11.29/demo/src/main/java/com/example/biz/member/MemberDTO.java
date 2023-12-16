package com.example.biz.member;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private String mId;
    private String mPw;
    private String mName;
}
