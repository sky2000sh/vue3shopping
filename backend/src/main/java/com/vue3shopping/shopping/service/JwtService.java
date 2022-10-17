package com.vue3shopping.shopping.service;

import io.jsonwebtoken.Claims;

public interface JwtService {
	
	//public
	String getToken(String key, Object value);
	
	Claims getClaims(String token);

}
