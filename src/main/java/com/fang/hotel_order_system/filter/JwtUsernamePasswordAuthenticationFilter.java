package com.fang.hotel_order_system.filter;

import com.fang.hotel_order_system.entity.JwtUser;
import com.fang.hotel_order_system.entity.User;
import com.fang.hotel_order_system.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            System.out.println("jwtUserPass: "+user.toString());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JwtUser user = (JwtUser) authResult.getPrincipal();
        System.out.println(user.toString());
        String token = JwtTokenUtil.createToken(user);
        response.setContentType("application/json; charset=utf-8");
        response.setHeader(JwtTokenUtil.TOKEN_HEADER, token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
