package com.formation.security.jwt;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class DecodeToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER= LoggerFactory.getLogger(DecodeToken.class);
	//@Value("${com.formation.jwtSecret}")
	private String jwtSecret="jwtbwsSecretKey";
	
	public Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			// TODO: handle exception
			claims = null;
			LOGGER.error("Error DecodeToken");
		}
		return claims;
	}
}
