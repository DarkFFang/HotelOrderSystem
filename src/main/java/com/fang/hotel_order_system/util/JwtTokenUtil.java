package com.fang.hotel_order_system.util;

import com.fang.hotel_order_system.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "Qnxj@xc!mk";
    private static final String ISS = "fang";

    private static final int EXPIRATION = 60 * 60 * 24;

    // 创建token
    public static String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .setIssuer(ISS)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }


    public static String createToken(JwtUser jwtUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", jwtUser.getUser().getUserId());
        claims.put("username", jwtUser.getUsername());
        return createToken(claims);
    }


    private static Claims getTokenClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // 从token中获取用户名
    public static String getUsernameFromToken(String token) {
        return getTokenClaims(token).get("username").toString();
    }

    public static Long getUserIdFromToken(String token) {
        return Long.valueOf(getTokenClaims(token).get("user_id").toString());
    }

    // 是否已过期
    public static boolean isExpiration(String token) {
        return getTokenClaims(token).getExpiration().before(new Date());
    }

    public static String refreshToken(String token) {
        Claims claims = getTokenClaims(token);
        claims.setIssuedAt(new Date());
        claims.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000));
        String refreshedToken = createToken(claims);
        return refreshedToken;
    }


    public static boolean validateToken(String token, String username) {
        String usernameFromToken = getUsernameFromToken(token);
        return (usernameFromToken.equals(username) && !isExpiration(token));
    }


}