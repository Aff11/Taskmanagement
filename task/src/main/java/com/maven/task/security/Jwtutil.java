package com.maven.task.security;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Jwtutil {

	private String SECRET_KEY = "mysecretkey";

    // Generate Token
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		 return extractClaim(token, Claims::getSubject);
	}
	
	 public Date extractExpiration(String token) {

	        return extractClaim(token, Claims::getExpiration);
	    }

	    // Extract specific claim
	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    
	    // Get all claims
	    private Claims extractAllClaims(String token) {

	        return Jwts.parser()
	                .setSigningKey(SECRET_KEY)
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    // Check token expiration
	    private Boolean isTokenExpired(String token) {

	        return extractExpiration(token).before(new Date());
	    }
	    
	    public Boolean validateToken(String token, UserDetails userDetails) {

	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
}
