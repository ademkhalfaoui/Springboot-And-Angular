package com.formation.security.jwt;

public class LoginResponse {

	private String code;
	private String token;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginResponse(String code, String token) {
		super();
		this.code = code;
		this.token = token;
	}
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
