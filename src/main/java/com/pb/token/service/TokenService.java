package com.pb.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.token.dao.TokenRepository;
import com.pb.token.exceptions.ExpiredTokenException;
import com.pb.token.exceptions.NotFoundException;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	/**
	 * Creates a token and returns the id
	 * @param expiryMinutes the expirey minutes for the token from now
	 * @return token id
	 */
	public String fetchToken(Integer expiryMinutes){
		return tokenRepository.fetchToken(expiryMinutes);
	}
	
	/**
	 * Checks whether a token is valid
	 * @param id the token id
	 * @throws NotFoundException if token was not found
	 * @throws ExpiredTokenException if token has been expired
	 */
	public void validateToken(String id) throws NotFoundException, ExpiredTokenException{
		tokenRepository.isTokenValid(id);
	}
}
