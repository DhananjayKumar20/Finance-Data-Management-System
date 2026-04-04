package com.zorvyn.dhananjay.config;

import com.zorvyn.dhananjay.exception.JwtValidationException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import java.util.Date;

@Component
public class JwtUtils {
    private Key key;

    @Value("${jwt.secret}")
    private String secret;

    // Default expiration: 8 hours in milliseconds
    @Value("${jwt.expiration-ms:28800000}")
    private long expirationMs;

    @PostConstruct
    public void init() {
        if (secret == null || secret.length() < 32) {
            throw new IllegalArgumentException("jwt.secret must be >= 32 characters");
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    // Generate JWT token
    public String generateToken(String email) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }
    // Extract email from JWT
    public String getEmailFromJwt(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            throw new JwtValidationException("Failed to parse JWT: " + e.getMessage());
        }
    }

    // Validate JWT token
    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new JwtValidationException("JWT expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new JwtValidationException("Unsupported JWT: " + e.getMessage());
        } catch (MalformedJwtException e) {
            throw new JwtValidationException("Malformed JWT: " + e.getMessage());
        } catch (SignatureException e) {
            throw new JwtValidationException("Invalid JWT signature: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new JwtValidationException("JWT claims string is empty: " + e.getMessage());
        }
    }
}
