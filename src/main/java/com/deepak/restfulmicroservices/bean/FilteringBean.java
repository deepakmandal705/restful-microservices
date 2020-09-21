package com.deepak.restfulmicroservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({ "activationKey", "password" })
@JsonFilter(value = "SampleBeanFilter")
public class FilteringBean {

	private String userName;
	private String organization;
	
	//@JsonIgnore
	private String activationKey;
	
	//@JsonIgnore
	private String password;

	public FilteringBean(String userName, String organization, String activationKey, String password) {
		super();
		this.userName = userName;
		this.organization = organization;
		this.activationKey = activationKey;
		this.password = password;
	}

	//setters & getters
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
