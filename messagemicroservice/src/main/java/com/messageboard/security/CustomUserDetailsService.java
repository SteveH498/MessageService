package com.messageboard.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.messageboard.domain.BoardUser;
import com.messageboard.repo.UserRepsitory;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepsitory userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BoardUser user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User does not exist!");
		}
		
	    List<SimpleGrantedAuthority> grantedAuths = new ArrayList<SimpleGrantedAuthority>();
	    grantedAuths.add(new SimpleGrantedAuthority("all"));
		
		return new User(user.getName(), user.getPasswordHash(), grantedAuths);
	}

}
