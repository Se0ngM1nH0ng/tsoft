package com.cos.security3.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TokenDTO {

    private String grantType; // 토큰 타입
    private int memberCode; // 인증받은 회원코드
    private String createToken; // 발급 토큰
    private String refreshToken; // 재발급 토큰
    private long createTokenExpiresIn; // 만료시간

}
