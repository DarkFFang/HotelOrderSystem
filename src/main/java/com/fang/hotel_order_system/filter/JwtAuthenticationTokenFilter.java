package com.fang.hotel_order_system.filter;


import com.fang.hotel_order_system.entity.JwtUser;
import com.fang.hotel_order_system.entity.Permission;
import com.fang.hotel_order_system.service.PermissionService;
import com.fang.hotel_order_system.service.UserService;
import com.fang.hotel_order_system.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import sun.dc.path.PathError;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {
    @Autowired
    private UserService userService;


    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader(JwtTokenUtil.TOKEN_HEADER);
        if (StringUtils.isNotEmpty(authHeader)) {
            String username = JwtTokenUtil.getUsernameFromToken(authHeader);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
/*
                UserDetails userDetails = (UserDetails) redisUtil.get("user:" + id.toString());

                if (userDetails == null) {
                    userDetails = userService.loadUserByUsername(phone);
                    redisUtil.set("user:" + id.toString(), userDetails);
                    redisUtil.expire("user:" + id.toString(), 60 * 60 * 3);
                }
*/
                UserDetails userDetails = userService.loadUserByUsername(username);

                if (JwtTokenUtil.validateToken(authHeader, username)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
