package com.vue3shopping.shopping.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtServiceImpl implements JwtService {
	
	private String secretKey = "aiekdivnbowmfjvifmdjwhdkvn922u4i5#$%kdeji34mekfoivk32%^&&*dkdkdu1j@#";

	@Override
	public String getToken(String key, Object value) {
		
		// 아래 명령어들은 입력받은 key와 value를 secretKey이용해서 만들어주는 서비스 메서드		
		Date expTime = new Date();
		expTime.setTime(expTime.getTime() + 1000 * 60 * 5);
		byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
		Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
		
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("typ", "JWT");
		headerMap.put("alg", "HS256");
		
		Map<String, Object> map = new HashMap<>();
		map.put(key, value);
		
		JwtBuilder builder = Jwts.builder().setHeader(headerMap)
				.setClaims(map)
				.setExpiration(expTime)
				.signWith(signKey, SignatureAlgorithm.HS256);

		return builder.compact();
	}

}
