package com.shopback.apigateway.auth;

import org.whispersystems.dropwizard.simpleauth.Authenticator;

import com.google.common.base.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * @author Karthik Jayaraman
 *
 */
public class AdminAuthenticator implements Authenticator<BasicCredentials, Admin> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.dropwizard.auth.Authenticator#authenticate(java.lang.Object)
	 */
	@Override
	public Optional<Admin> authenticate(BasicCredentials credentials) throws AuthenticationException {
		if ("@dmin".equals(credentials.getPassword()) && "admin".equals(credentials.getUsername())) {
			return Optional.of(new Admin(credentials.getUsername()));
		}
		return Optional.absent();
	}

}
