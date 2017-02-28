package com.messageboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordAuthenticationManager implements AuthenticationManager {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
	    String username = String.valueOf(auth.getPrincipal());
	    String password = String.valueOf(auth.getCredentials());
	    
	    // Check if user and password are valid
		 User user = (User)
		 customUserDetailsService.loadUserByUsername(username);
	    
	    if(null == user || (! BCrypt.checkpw(password, user.getPassword()))) {
	        throw new BadCredentialsException("Invalid username or password");
	    }

	    // Create new authentication token
	    auth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), user.getAuthorities());
	    auth.setDetails(user);
	    return auth;		
	}

}
