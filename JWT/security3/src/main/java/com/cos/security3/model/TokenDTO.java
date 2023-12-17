package com.cos.security3.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TokenDTO {

    private String type; // 토큰 타입
    private int memberCode; // 인증받은 회원코드
    private String createToken; // 발급 토큰
    private String refreshToken; // 재발급 토큰
    private long createTokenExpiresIn; // 만료시간

    public TokenDTO(String bearerType, String mId, String createToken, String refreshToken, long time) {
    }
}
