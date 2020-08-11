package com.tvmreza.api.security.utility;

public class SecurityConstant {

	public static final long EXPIRATION_TIME = 36000000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String JWT_TOKEN_HEADER = "Jwt-Token";
	public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
	public static final String GET_ARRAYS_LLC = "TV Mreza";
	public static final String GET_ARRAYS_ADMINISTRATION = "User management";
	public static final String AUTHORITIES = "Authorities";
	public static final String FORBIDDEN_MESSAGE = "You need to log in to access";
	public static final String ACCESS_DENIED_MESSAGE = "Access denied";
	public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
	public static final String[] PUBLIC_URLS = { "/public/**" };
}
