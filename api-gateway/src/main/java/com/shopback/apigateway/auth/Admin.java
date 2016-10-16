package com.shopback.apigateway.auth;

import java.security.Principal;

/**
 * @author Karthik Jayaraman
 *
 */
public class Admin implements Principal {
	private String name;

	Admin(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

}
