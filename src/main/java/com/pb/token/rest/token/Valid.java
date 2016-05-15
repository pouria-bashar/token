package com.pb.token.rest.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pb.token.exceptions.ExpiredTokenException;
import com.pb.token.exceptions.NotFoundException;
import com.pb.token.service.TokenService;

@RestController
public class Valid {

	@Autowired
	TokenService tokenService;

	@RequestMapping(value = "/valid", method = RequestMethod.GET)
	public ResponseEntity<String> getToken(@RequestParam(name = "id", required = true) String id) {
		try {
			tokenService.validateToken(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NotFoundException ex) {
			return new ResponseEntity<String>(ex.getMessage() , HttpStatus.NOT_FOUND);
		} catch (ExpiredTokenException ex) {
			return new ResponseEntity<String>(ex.getMessage() ,HttpStatus.UNAUTHORIZED);
		}
		

	}
}
