package com.cos.security3.model;

import com.cos.security3.jwt.TokenProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Service
@RequiredArgsConstructor
public class MemberService implements InterfaceMemberService {

    private final InterfaceMemberDAO mDAO;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;


    // 중복검사
    public MemberDTO selectOne(MemberDTO mDTO) {

        return mDAO.selectOne(mDTO.getMId());
    }

    // 로그인
    // 로그인 시 토큰 발급을 추가
    @Transactional
    public TokenDTO selectOne_login(MemberDTO mDTO) {

        MemberDTO mData = mDAO.findMyId(mDTO.getMId());
        TokenDTO token = new TokenDTO();

        if(mData != null && passwordEncoder.matches(mDTO.getPassword(), mData.getPassword())){
            int mCode = mData.getMCode();
            List<MemberRoleDTO> memberRoleList = mDAO.getAuthList(mCode);

            for(MemberRoleDTO mRole : memberRoleList){
                AuthorityDTO auth = mDAO.findAuth(mRole.getAuthorityCode());
                mRole.setAuthority(auth);
            }
            mDTO.setMRole(memberRoleList);

            token = tokenProvider.generateTokenDTO(mDTO);

            Map<String, Object> map = new HashMap<>();
            map.put("refreshToken", token.getRefreshToken());
            map.put("mCode", mCode);
            mDAO.refreshToken(map);
            token.setMemberCode(mData.getMCode());
        }


        return token;
    }

    // 토큰 검사

    public  Object check(String token){

        boolean flag = tokenProvider.validationToken(token);

        if(!flag){
            Claims auth = tokenProvider.getAuth(token);
            String refreshToken = mDAO.findToken(auth.getSubject());

            boolean flag2 = tokenProvider.validationToken(refreshToken);
            if(flag2){
                String accessToken = tokenProvider.createToken(refreshToken);
                return accessToken;
            }
        }
        else{
            return true;
        }
        return false; // 만료
    }

    // 회원가입
    public boolean insert(MemberDTO mDTO){
        Map<String, Object> map = new HashMap<>();
        map.put("data1", mDTO.getMId());
        map.put("data2", mDTO.getMPw());
        map.put("data3", mDTO.getMName());
        map.put("data4", mDTO.getMRole());

        return mDAO.insert(map);
    }

    // 권한 변경
    @Override
    public boolean update(String username, String role) {
        Map<String, Object> map = new HashMap<>();
        map.put("data1",role);
        map.put("data2",username);
        return mDAO.update(map);
    }


}
