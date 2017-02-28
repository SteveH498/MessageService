package com.messageboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerAdapter extends AuthorizationServerConfigurerAdapter {

	// The default AuthenticationManager has a single user (‘user’ username and
	// random password, printed at INFO level when the application starts up)
	// @Autowired
	// private AuthenticationManager authenticationManager;

	
	// Provide custom AuthenticationManager
	@Autowired
	PasswordAuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// You shouldn't need to do anything by default, unless you need
		// password grants, in which case you need to provide an
		// AuthenticationManager
		endpoints.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("message-service").secret("message-service-secret")
				.authorizedGrantTypes("password").scopes("all");
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

}
