package com.formation.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.formation.security.services.UserDeatilsServiceImpl;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter{
	
	private static final Logger LOGGER= LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private DecodeToken decodeToken;
	@Autowired
	private UserDeatilsServiceImpl deatilsServiceImpl;	
	private 	UserDetails userDetails;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String jwt = getJwt(request);
			if(jwt !=null && jwtProvider.validateJwtToken(jwt)) {
				Claims claims=decodeToken.getAllClaimsFromToken(jwt);
				String username= claims.get("username").toString();
				this.userDetails = deatilsServiceImpl.loadUserByUsername(username);
				System.out.println(this.userDetails);
				UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Can not set user authentication ", e);
		}
		filterChain.doFilter(request, response);
	}
	
	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ","");
		}
		return null;
	}
public  UserDetails getUserDetails() {
	return this.userDetails;
}
}
