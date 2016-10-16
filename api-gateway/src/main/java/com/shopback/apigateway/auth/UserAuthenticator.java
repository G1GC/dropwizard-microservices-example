package com.shopback.apigateway.auth;

import org.whispersystems.dropwizard.simpleauth.Authenticator;

import com.google.common.base.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * @author Karthik Jayaraman
 *
 */
public class UserAuthenticator implements Authenticator<BasicCredentials, User> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.dropwizard.auth.Authenticator#authenticate(java.lang.Object)
	 */
	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if ("$hopback".equals(credentials.getPassword()) && "shopback".equals(credentials.getUsername())) {
			return Optional.of(new User(credentials.getUsername()));
		}
		return Optional.absent();
	}

}
