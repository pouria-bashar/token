package com.pb.token.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pb.token.exceptions.ExpiredTokenException;
import com.pb.token.exceptions.NotFoundException;
import com.pba.token.entities.TokenDocument;

@Repository
public class TokenRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	/**
	 * Creates a new token and returns the id
	 * @param expiryMinutes maximum time for the token to live from the current time
	 * @return token
	 */
	public String fetchToken(Integer expiryMinutes){
		String id = UUID.randomUUID().toString();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Date createDateTime = cal.getTime();
		cal.add(Calendar.MINUTE, expiryMinutes);
		Date expiryDateTime = cal.getTime();
			
		TokenDocument tokenDocument = new TokenDocument();
		tokenDocument.setId(id);
		tokenDocument.setCreateDateTime(createDateTime);
		tokenDocument.setExpiryDateTime(expiryDateTime);
		tokenDocument.setExpiryMinutes(expiryMinutes);
		
		mongoTemplate.insert(tokenDocument);
		
		
		return id;
	}
	
	/**
	 * Checks if a token is still valid
	 * @param id the token identfier
	 * @return true if token is valid
	 * @throws NotFoundException if token is not found
	 * @throws ExpiredTokenException if token has been expired
	 */
	public void isTokenValid(String id) throws NotFoundException , ExpiredTokenException{
		TokenDocument tokenDocument = mongoTemplate.findById(id, TokenDocument.class);
		if(tokenDocument == null){
			throw new NotFoundException("Token with id " + id + " was not found");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		if(cal.before(tokenDocument.getExpiryDateTime())){
			throw new ExpiredTokenException("Token with id " + id + " has been expired");
		}
		
	}
}
