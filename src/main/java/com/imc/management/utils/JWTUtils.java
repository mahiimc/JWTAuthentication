package com.imc.management.utils;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.imc.management.dto.AuthToken;
import com.imc.management.exception.InvalidTokenException;
import com.imc.management.model.SecuredUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * The Class JWTUtils.
 */
@Component
public class JWTUtils {
	
	 	/** The Constant SECRET_KEY. */
	 	private static final String SECRET_KEY = "StrongSECRETKEYForSpringSecurityd2iho23kru32hr2or2r32or2rh2rjb2rk2jrb2krbj2rkj2brk2jrrh2ro2r32hrl23jr2hrk2hkrj2bmbcskcbcsdcjsbcksjwkwjbwfjbwfkwfbwkfwjfwkfjwbfewkfjwfkwfwkfur2ioru23yro2jb2kjb2kjbkj2bk2hr2or2kjr2jbr2krb2krj2";
	    
    	/** The Constant ACCESS_TOKEN_EXPIRATION_TIME. */
    	private static final long ACCESS_TOKEN_EXPIRATION_TIME = 900000; // 15 minutes
	    
    	/** The Constant REFRESH_TOKEN_EXPIRATION_TIME. */
    	private static final long REFRESH_TOKEN_EXPIRATION_TIME = 2592000000L; // 30 days
	    
    	/** The Constant keysPath. */
    	private static final String keysPath = "/keys";
	    
    	/** The keys. */
    	private static ConcurrentHashMap<String, Key> keys = null;
	    
	    /** The user details service. */
    	@Autowired
	    private UserDetailsService userDetailsService;
	    
	    
	    /**
    	 * Instantiates a new JWT utils.
    	 *
    	 * @throws NoSuchAlgorithmException the no such algorithm exception
    	 */
    	public JWTUtils() throws NoSuchAlgorithmException {
	    	if(keys == null) {
//	    		loadRSAKeys();
	    	}
	    }
	    
	    /**
    	 * Load RSA keys.
    	 *
    	 * @throws NoSuchAlgorithmException the no such algorithm exception
    	 */
    	private void loadRSAKeys() throws NoSuchAlgorithmException {
	    	keys = new ConcurrentHashMap<>();
	    	
	    	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	    	KeyPair keypair = keyPairGenerator.generateKeyPair();
	    	keys.put("private", keypair.getPrivate());
	    	keys.put("public", keypair.getPublic());
	    }

		/**
		 * Generate token.
		 *
		 * @param authentication the authentication
		 * @return the auth token
		 */
		public  AuthToken generateToken(Authentication authentication) {
			
			Date now = new Date();
			Date expirationDate = new Date(now.getTime() + ACCESS_TOKEN_EXPIRATION_TIME);
			
			String token =  Jwts.builder()
					.setClaims(Map.of("roles",authentication.getAuthorities()))
					.setExpiration(expirationDate)
					.setIssuedAt(expirationDate)
					.setIssuer("IMC Solutions")
					.setSubject(authentication.getPrincipal().toString())
					.setId(UUID.randomUUID().toString())
					.signWith(SignatureAlgorithm.HS256,SECRET_KEY)
					.compact();
			return AuthToken.builder()
					.token(token)
					.expiresAt(expirationDate.toString())
					.build();
		}
	
		/**
		 * Validate token.
		 *
		 * @param token the token
		 * @return true, if successful
		 */
		public  boolean validateToken(String token) {
			String subject = extractSubjectFromToken(token);
			SecuredUser user = (SecuredUser) userDetailsService.loadUserByUsername(subject);
			isTokenExpired(token);
			if ((subject != null && user.getUser().getUsername() != null)
					&& subject.equalsIgnoreCase(user.getUser().getUsername())) {
				Authentication authentication = new UsernamePasswordAuthenticationToken(subject,null,user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
				return true;
			}
			throw new InvalidTokenException("Token is Invalid");
		}
		
		/**
		 * Checks if is token expired.
		 *
		 * @param token the token
		 * @return true, if is token expired
		 */
		public  boolean isTokenExpired(String token) {
			if(getAllClaims(token).getExpiration().before(new Date())) {
				throw new InvalidTokenException("Token has been expired.");
			}
			return false;
		}
	
		
		/**
		 * Gets the all claims.
		 *
		 * @param token the token
		 * @return the all claims
		 */
		private Claims getAllClaims(String token) {
			try {
				return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
			}
			catch (ExpiredJwtException e) {
				throw new InvalidTokenException("Token has been expired!");
			}

		}
		
		
		/**
		 * Extract subject from token.
		 *
		 * @param token the token
		 * @return the string
		 */
		public  String extractSubjectFromToken(String token) {
			return getAllClaims(token).getSubject();
		}
		
		

}
