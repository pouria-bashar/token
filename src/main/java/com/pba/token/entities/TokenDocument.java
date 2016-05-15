package com.pba.token.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "token")
public class TokenDocument {

	private String id;
	private Integer expiryMinutes;
	private Date createDateTime;
	private Date expiryDateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getExpiryMinutes() {
		return expiryMinutes;
	}
	public void setExpiryMinutes(Integer expiryMinutes) {
		this.expiryMinutes = expiryMinutes;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Date getExpiryDateTime() {
		return expiryDateTime;
	}
	public void setExpiryDateTime(Date expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

	
}
