package com.example.demo.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()  // csrf와 cors를 비활성화, 웹페이지가 있는 경우 csrf를 비활성화 하지 않는 경우 있음
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        // .requestMatchers().permitAll()  // 서버가 접근 가능한 파일 경로 추가
                        .anyRequest().authenticated()   // 어떠한 요청이라도 인증 필요
                )
                .formLogin(login -> login   // form 방식 로그인 사용
                        .loginPage("/view/login")   // 로그인 페이지 설정
                        .loginProcessingUrl("/login-process")   // submit 받을 url
                        .usernameParameter("userid")    // submit할 아이디
                        .passwordParameter("pw")    // submit할 비밀번호
                        .defaultSuccessUrl("/view/dashboard", true) // 성공시 dashboard로
                        .permitAll()    // 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout(withDefaults());
        return http.build();
    }
//    @PostMapping("/login-process")    // 로그인 submit 처리하는 함수
//    public String login(MemberLoginDto dto){
//        boolean isValidMember = memberService.isValidMember(dto.getUserid(), dto.getPw());
//        if (isValidMember)
//            return "dashboard";
//        return "login";
//    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new SimplePasswordEncoder();
    }
}
