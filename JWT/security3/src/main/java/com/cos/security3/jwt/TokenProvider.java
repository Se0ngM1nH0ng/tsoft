package com.cos.security3.jwt;

import com.cos.security3.config.auth.PrincipalDetails;
import com.cos.security3.config.auth.PrincipalDetailsService;
import com.cos.security3.model.MemberDTO;
import com.cos.security3.model.TokenDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.Transform;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {


    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer"; // Bearer 토큰 사용 , prefix 문자열
    private static final long CREATE_TOKEN_EXPIRE_TIME = 1000 * 60; // 1분 ms단위
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 ; // 1일
    private Key key; // Security 안에 있다.
    private final PrincipalDetailsService principalDetailsService;

    public TokenProvider(@Value("${jwt.secret}") String secret,
                        PrincipalDetailsService principalDetailsService){
        byte[] keyBytest = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytest);
        this.principalDetailsService = principalDetailsService;
    }


    public String createToken(String refreshToken){
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(refreshToken).getBody();
        long now = System.currentTimeMillis();
        Date createTokenExpiresIn = new Date(now + CREATE_TOKEN_EXPIRE_TIME);

        String createToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(createTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return createToken;
    }

    // 토큰 생성 메서드
    public TokenDTO generateTokenDTO(MemberDTO mDTO){
       // 회원 아이디를 Subject 라는 클레임으로 토큰에 추가 한다.
        Claims claims = Jwts.claims().setSubject(mDTO.getMId());

        // 회원의 권한을 "auth" 라는 클래임으로 토큰에 추가 한다.
        claims.put(AUTHORITIES_KEY, mDTO.getMRole());

        long now = System.currentTimeMillis();

        Date createTokenExpiresIn = new Date(now + CREATE_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);

        String createToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(createTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return new TokenDTO(BEARER_TYPE, mDTO.getMId(), createToken, refreshToken, createTokenExpiresIn.getTime());
    }

    public String getMid(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody() // payload 의 Claims 추출
                .getSubject(); // 등록된 클레임에 해당하는 sub 값 추출 ( 회원아이디 )
    }

    // createToken 에서 클레임 추출하는 메서드
    private Claims parseClaims(String token) {
        try{
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();   // 토큰이 만료되어도 클레임 값을 뽑을 수 있다 !
        }
    }

    // createToken 으로 인증 객체 추출
    public Authentication getAuthentication(String token){
        Claims claims = parseClaims(token);

        if(claims.get(AUTHORITIES_KEY) == null){
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        PrincipalDetails principalDetails = (PrincipalDetails) principalDetailsService.loadUserByUsername(this.getMid(token));

        return new UsernamePasswordAuthenticationToken(principalDetails, "", principalDetails.getAuthorities());
    }

    public Claims getAuth(String token){
        Claims claims = parseClaims(token);

        if(claims.getExpiration().getTime() < System.currentTimeMillis()){
            return claims;
        }
        return null;
    }


    // 토큰 유효성 검사
    public Boolean validationToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new TokenException("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            return false;
            //logger.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {

            throw new TokenException("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {

            throw new TokenException("JWT 토큰이 잘못되었습니다.");
        }


    }
}
