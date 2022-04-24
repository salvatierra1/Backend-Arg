package com.salvatierravictor.portfolio.auth.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {

    private String SECRET_KEY = "secret";

    // Utils:
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Resolucion:
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // isExpired before Today?
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate Token for USER:
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }
    private String createToken(Map<String, Object> claims, String subject) {
        // Creamos Token
        return Jwts.builder().setClaims(claims).setSubject(subject)
                // FechaCreated:
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // "FechaCreated" + 10hs
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                // Algoritmo y Clave:
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                // GO!
                .compact();
    }

    // UTILS:
    public Boolean validateToken (String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        // Comparamos usuario extraido del token con usuario en Context
        // && verificamos token vigente:
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
