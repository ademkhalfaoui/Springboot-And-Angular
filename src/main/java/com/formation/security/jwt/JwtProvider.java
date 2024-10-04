package com.formation.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    //@Value("${com.formation.jwtExpiration}")
    private int jwtExpiration = 86400;
    //@Value("${com.formation.jwtSecret}")
    private String jwtSecret = "jwtbwsSecretKey";

    public String generateJwtToken(TokenObject tokenObject) {
        Claims claims = Jwts.claims().setSubject(tokenObject.getUsername());
        claims.put("id", tokenObject.getId());
        claims.put("username", tokenObject.getUsername());
        claims.put("nom", tokenObject.getNom());
        claims.put("prenom", tokenObject.getPrenom());
        claims.put("role", tokenObject.getRole());

        // Générer le jeton JWT en utilisant les revendications configurées
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            LOGGER.error("invalid JWT");
            return false;
        }
    }

}
