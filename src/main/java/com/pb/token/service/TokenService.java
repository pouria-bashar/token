package com.pb.token.service;

import org.springframework.stereotype.Service;

import com.pba.token.entities.TokenDocument;

@Service
public class TokenService {

	public TokenDocument getToken(String expiryMinutes){
		return new TokenDocument();
	}
}
