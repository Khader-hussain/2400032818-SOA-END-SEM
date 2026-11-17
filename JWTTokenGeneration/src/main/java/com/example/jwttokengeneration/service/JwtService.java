
package com.example.jwttokengeneration.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username, String role) {

        SecretKey key = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret));

        long currentTime = System.currentTimeMillis();

        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date(currentTime))
                .expiration(new Date(currentTime + 3600000))
                .signWith(key)
                .compact();
    }
}
