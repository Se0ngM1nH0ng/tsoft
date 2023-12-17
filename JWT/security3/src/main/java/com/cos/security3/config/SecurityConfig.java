package com.cos.security3.config;


import com.cos.security3.jwt.JwtAccessDeniedHandler;
import com.cos.security3.jwt.JwtAuthenticationEntryPoint;
import com.cos.security3.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration

@EnableWebSecurity
@Component
//@EnableMethodSecurity(securedEnabled = true) // secured 어노테이션 활성화
public class SecurityConfig {


    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider,
                          JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
                          JwtAccessDeniedHandler jwtAccessDeniedHandler){
        this.tokenProvider = tokenProvider;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    // 비밀번호 암호화 메서드
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // Security FilterChain이 먼저 동작하고 나서 내가 만든 필터가 동작한다.
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        //http.addFilterBefore(new MyFilter3(), SecurityContextHolderFilter.class);
        http.csrf(CsrfConfigurer::disable)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler))
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .apply();
                //세션을 생성하지 않고, 요청 간의 상태를 유지하지 않는다. 세션을 만드는 방식을 하지 않겠다 설정
                http.httpBasic(HttpBasicConfigurer::disable)
                .cors(cors -> corsFilter()) // @CrossOrigin(인증 x) , 시큐리티 필터에 등록 인증 (o)
                .authorizeHttpRequests(request -> request
                                .requestMatchers("/user/**").authenticated()
                                .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                        );


        http.formLogin(login -> login
                .loginPage("/loginForm")
                .defaultSuccessUrl("/index"));



        return http.build();
    }

    @Bean
    CorsConfigurationSource corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답시 json을 js에서 처리할 수 있게 할지를 설정
        // false 시 js 로 오는 요청을 허용하지 않는다.
        config.addAllowedOrigin("*"); // 모든 ip 에 응답을 허용
        config.addAllowedHeader("*"); // 모든 header에 응답 허용
        config.addAllowedMethod("*"); // 모든 httpMethod 요청 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
