package com.myfirstproject.productlist.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private static String secretKey;

    // Constructor to generate a random Base64-encoded 256-bit secret key
    public JwtUtils() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits
        random.nextBytes(key);
        secretKey = Base64.getEncoder().encodeToString(key);
    }

    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2)) // 2 minutes
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignedKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}