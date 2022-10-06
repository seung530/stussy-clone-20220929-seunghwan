package com.stussy.stussyClone20220929seunghwan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity  // 기존의 WebSecurityConfigurerAdapter 클래스를 해당 SecurityConfig로 대체
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()  // 모든 요청 시에 실행을 해라
                .antMatchers("/test/**", "/index")  // (주소 확인) 해당 요청 주소들은
                .authenticated()  // 인증이 필요하다
                .anyRequest()  // antMatchers 외의 다른 모든 요청은 
                .permitAll()  // 모두 접근 권한을 허용해라
                .and()  // 그리고 
                // and() 가 없다면 http.formLogin() 으로 다시 지정해줘야함
                .formLogin()  // 폼로그인 방식으로 인증을 해라
                .loginPage("/account/login")  // 우리가 만든 로그인 페이지를 사용해라
                .defaultSuccessUrl("/index");  // (이전 페이지가 없을 경우) 로그인 성공시 접속되는 페이지
    }
}
