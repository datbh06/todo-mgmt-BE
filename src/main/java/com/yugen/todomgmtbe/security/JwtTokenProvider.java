package com.yugen.todomgmtbe.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * This class provides utility methods for generating, parsing, and validating JWT tokens.
 */
@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private Long jwtExpirationDate;

    /**
     * Generates a JWT token for the given authentication.
     *
     * @param authentication the authentication object
     * @return the generated JWT token
     */
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + jwtExpirationDate);

        return Jwts.builder().setSubject(username).setIssuedAt(currentDate).setExpiration(expiryDate).signWith(key()).compact();
    }

    /**
     * Returns the key used to sign the JWT token.
     *
     * @return the key used to sign the JWT token
     */
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    /**
     * Returns the username from the given JWT token.
     *
     * @param token the JWT token
     * @return the username from the given JWT token
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validates the given JWT token.
     *
     * @param token the JWT token
     * @return true if the given JWT token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
        return true;
    }
}
