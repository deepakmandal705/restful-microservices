package com.deepak.restfulmicroservices.bean;

public class MessageBean {
	
	private String message;

	
	public MessageBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
