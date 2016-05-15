package com.pb.token.rest.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pb.token.service.TokenService;

@RestController
public class Token {

	@Autowired
	TokenService tokenService;
	
	@RequestMapping(value = "/Token", method = RequestMethod.GET)
	public ResponseEntity<String> getToken(@RequestParam(name = "expiryMinutes", required = true) Integer expiryMinutes) {
			
		return new ResponseEntity<String>(tokenService.fetchToken(expiryMinutes),HttpStatus.OK);
		
	}
}
