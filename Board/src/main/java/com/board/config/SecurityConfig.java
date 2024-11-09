package com.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/inquiry/comment").hasRole("ADMIN") // 관리자만 댓글 작성 가능
                .anyRequest().permitAll() // 그 외 요청은 모두 허용
            .and()
            .formLogin() // 기본 로그인 페이지 사용
                .loginPage("/login") // 로그인 페이지 커스터마이징이 필요하면 추가
            .and()
            .logout().permitAll(); // 로그아웃 허용
    }
}
