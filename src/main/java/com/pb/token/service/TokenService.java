package com.pb.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.token.dao.TokenRepository;
import com.pba.token.entities.TokenDocument;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	public String fetchToken(Integer expiryMinutes){
		return tokenRepository.fetchToken(expiryMinutes);
	}
	
	
	public boolean validateToken(String token){
		return true;
	}
}
