package com.pitech.order_app_backend.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${orderapp.app.secret}")
	private String APP_SECRET;
	
	@Value("${orderapp.expires.in}")
	private long EXPIRES_IN;
	
	public String generateJwtToken(Authentication auth) {
		JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
		Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
		return Jwts.builder().setSubject(Long.toString(userDetails.getId()))
				.setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
	}
	
	public String generateJwtTokenByUserId(Long userId) {
		Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
		return Jwts.builder().setSubject(Long.toString(userId))
				.setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
	}
	
	Long getUserIdFromJwt(String token) {
		Claims claims = Jwts.parser().setSigningKey(APP_SECRET).build().parseSignedClaims(token).getPayload();

		return Long.parseLong(claims.getSubject());
	}
	
	boolean validateToken(String token) {
		System.out.println("Token Validation: " + token);
		try {
			Jwts.parser().setSigningKey(APP_SECRET).build().parseSignedClaims(token).getPayload();
			return !isTokenExpired(token);
		} catch (SignatureException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (Exception e) {
        	System.out.println(e);
			return false;
		}
	}

	private boolean isTokenExpired(String token) {
		Claims claims = Jwts.parser().setSigningKey(APP_SECRET).build().parseSignedClaims(token).getPayload();
		
		Date expiration = claims.getExpiration();
		System.out.println("Token bitti mi: " + expiration.before(new Date()));
		return expiration.before(new Date());
	}

}