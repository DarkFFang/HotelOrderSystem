package com.fang.hotel_order_system.security;

import com.fang.hotel_order_system.filter.JwtAuthenticationTokenFilter;
import com.fang.hotel_order_system.filter.JwtUsernamePasswordAuthenticationFilter;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.filter.CorsFilter;

/**
 * 网络安全配置
 *
 * @author fang
 * @date 2020/12/14
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 用户详细信息服务
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    /**
     * 密码编码器
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 配置
     *
     * @param auth 身份验证
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }



    /**
     * 配置
     *
     * @param http http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()
                .antMatchers("/druid/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/user/loginByVerifyCode").permitAll()
                .antMatchers("/api/user//sendLoginVerifyCode").permitAll()
                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/api/user/sendVerifyCode").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();

        http.addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationTokenFilter(authenticationManager(), userService));


        http.logout()
                .logoutUrl("/logout");

    }

}
