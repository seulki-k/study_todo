//package com.example.todo_crud.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // CSRF 비활성화
//                .formLogin().disable() // 폼 로그인 비활성화
//                .httpBasic().disable() // HTTP Basic 인증 비활성화
//                .authorizeRequests()
//                .antMatchers("/", "/login", "/join").permitAll() // 특정 경로에 대한 접근 허용
//                .antMatchers("/admin").hasRole("ADMIN") // ADMIN 역할을 가진 사용자만 접근 허용
//                .anyRequest().authenticated() // 나머지 모든 요청은 인증 필요
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 비사용
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // Static resource 접근을 위한 설정이 필요한 경우
//        web.ignoring().antMatchers("/resources/**", "/static/**", "/public/**");
//    }
//}
