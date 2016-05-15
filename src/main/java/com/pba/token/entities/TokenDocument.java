package com.pba.token.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "token")
public class TokenDocument {

	private String id;
	private String expiryMinutes;
	private String createDateTime;
	private String expiryDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpiryMinutes() {
		return expiryMinutes;
	}

	public void setExpiryMinutes(String expiryMinutes) {
		this.expiryMinutes = expiryMinutes;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getExpiryDateTime() {
		return expiryDateTime;
	}

	public void setExpiryDateTime(String expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

}
