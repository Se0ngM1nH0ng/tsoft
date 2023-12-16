package com.example.securitytest1.security;

import com.example.securitytest1.service.MemberService;
import com.example.securitytest1.service.MyloginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.And;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity

public class SecurityConfig {

    private final MemberService memberService;



    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 리소스들이 보안필터를 거치지 않게끔
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**", "/font/**");
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests  // 요청에 의한 보안 검사 시작
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/user").hasAnyRole("USER", "ADMIN") // user를 들어갈 수 있는 권한은 USER 이다.
                        .requestMatchers("/admin").hasRole("ADMIN") // admin을 들어갈 수 있는 권한은 ADMIN 이다
                        .anyRequest().authenticated() // 위 이외의 다른 요청들은 보안 검사가 필요하다
                )
                .httpBasic(withDefaults());
        http.formLogin(login -> login   // withDefaults() 기본 구성
                .loginPage("/login")// 사용자 정의 로그인 페이지 "/login"
//                .defaultSuccessUrl("/loginSuccess")// 로그인 성공 후 이동 페이지
//                .failureUrl("/view/main?error=true") // 로그인 실패 후 이동 페이지
//                .usernameParameter("mId")// 아이디 파라미터명 설정
//                .passwordParameter("mPw")// 패스워드 파라미터명 설정
//                .loginProcessingUrl("/loginCheck")// 로그인 Form Action Url
               // .successHandler(new MyloginSuccessHandler()) // 로그인 성공 후 핸들러
                );

        return http.build();
    }



    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        PasswordEncoder encoder = passwordEncoder();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()
                .username("admin")
                .password(encoder.encode("12"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }


}