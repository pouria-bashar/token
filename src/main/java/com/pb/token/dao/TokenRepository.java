package com.pb.token.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pba.token.entities.TokenDocument;

@Repository
public class TokenRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
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
}
