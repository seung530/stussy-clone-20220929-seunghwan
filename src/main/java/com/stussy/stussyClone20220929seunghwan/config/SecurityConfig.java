package com.stussy.stussyClone20220929seunghwan.config;

import com.stussy.stussyClone20220929seunghwan.handler.auth.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity  // 기존의 WebSecurityConfigurerAdapter 클래스를 해당 SecurityConfig로 대체
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean  // configuration 내에서만 등록 가능하다, 이것을 통해 Ioc에 등록한다.
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests()  // 모든 요청 시에 실행을 해라

                /*<<<<<<<<<<<<<<<<<<  PAGE  >>>>>>>>>>>>>>>>>>*/
//                .antMatchers("/admin/**", "/api/admin/**")
//                .access("hasRole('ADMIN') or hasRole('MANAGER')")  // 여러개의 권한 부여
//                .hasRole("ADMIN")  // 하나의 권한 부여
                .antMatchers("/account")  // (주소 확인) 해당 요청 주소들은
                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('MANAGER')")  // 여러개의 권한 부여
//                .authenticated()  // 인증이 필요하다
                .antMatchers("/", "/index", "/collections/**")
                .permitAll()
                .antMatchers("/account/login", "/account/register")
                .permitAll()

                /*<<<<<<<<<<<<<<<<<<  RESOURCE  >>>>>>>>>>>>>>>>>>*/
                .antMatchers("/static/**", "/image/**") // static, image 로의 접속은
                .permitAll()  // 모두 접근 권한을 허용해라

                /*<<<<<<<<<<<<<<<<<<  API  >>>>>>>>>>>>>>>>>>*/
                .antMatchers("/api/account/register", "/api/collections/**") //
                .permitAll()

                .anyRequest()  // antMatchers 외의 다른 모든 요청은
                .permitAll()
//                .denyAll()  // 모두 접근 권한을 차단해라  <<  의미만 파악, 수업 중 사용안함  >>

                .and()  // 그리고
                // and() 가 없다면 http.formLogin() 으로 다시 지정해줘야함
                .formLogin()  // 폼로그인 방식으로 인증을 해라
                .usernameParameter("email")  // username의 디폴트는 username 이므로 로그인 시 사용되는 email type 으로 변경해라
                .loginPage("/account/login")  // 우리가 만든 로그인 페이지를 사용해라  [GET 요청] 
                .loginProcessingUrl("/account/login")  // 로그인 로직 (PrincipalDetailsService) [POST 요청]
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index");  // (이전 페이지가 없을 경우) 로그인 성공시 접속되는 페이지
    }
}
