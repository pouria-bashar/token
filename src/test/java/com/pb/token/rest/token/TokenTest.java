package com.pb.token.rest.token;

import org.junit.Test;

import com.pba.token.entities.TokenDocument;

public class TokenTest {

	@Test
	public void test_getToken() {
		Token token = new Token();
		final String EXPIRY_MINUTES = "10";
		TokenDocument tokenDocument = token.getToken(EXPIRY_MINUTES);
		
	}

}
