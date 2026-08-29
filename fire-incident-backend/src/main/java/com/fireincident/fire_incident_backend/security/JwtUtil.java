package com.fireincident.fire_incident_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret:fireincident-secret-key-1234567890-abcdefghijklmnopqrstuvwxyz}")
    private String secret;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // Generates a JWT token for the given email with a 24-hour expiry.
    public String generateToken(String email) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 24 * 60 * 60 * 1000L);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extracts the email stored in the JWT subject claim.
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Validates that the token is signed correctly and not expired for the provided email.
    public boolean validateToken(String token, String email) {
        try {
            Claims claims = getClaims(token);
            return email.equals(claims.getSubject()) && !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
