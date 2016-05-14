package com.pb.token.rest.token;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pba.token.entities.TokenDocument;

@RestController
public class Token {

	@RequestMapping(path = "/Token", method = RequestMethod.GET)
	public TokenDocument getToken(@RequestParam(name = "expiryMinutes", required = true) String expiryMinutes) {

		return new TokenDocument();
	}
}
