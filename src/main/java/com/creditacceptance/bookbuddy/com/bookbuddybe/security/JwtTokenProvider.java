package com.creditacceptance.bookbuddy.com.bookbuddybe.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component

public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-ms}")
    private String jwtExpirationMs;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + Long.parseLong(jwtExpirationMs));

        String jwt = Jwts.builder().setSubject(username).setIssuedAt(currentDate).setExpiration(expirationDate).signWith(key()).compact();

        return jwt;

    }
    public String getUserName(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
        String username = claims.getSubject();
        return username;
    }

    public boolean validateToken(String token){
        Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
        return true;
    }

    public Key key(){
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }
}
