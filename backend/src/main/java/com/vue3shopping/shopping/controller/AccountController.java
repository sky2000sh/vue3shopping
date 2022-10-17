package com.vue3shopping.shopping.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vue3shopping.shopping.entity.Member;
import com.vue3shopping.shopping.repository.MemberRepository;
import com.vue3shopping.shopping.service.JwtService;
import com.vue3shopping.shopping.service.JwtServiceImpl;

@RestController
public class AccountController {
	
	@Autowired
	MemberRepository memberRepository;
	
	// 아래 post로 데이터를 요청받는데, 인자값을 param으로 받고 그 안에 email, password를 던져서 id 값을 리턴해준다.
	@PostMapping("/api/account/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> param, HttpServletResponse res) {
		
		Member member = memberRepository.findByEmailAndPassword(param.get("email"), param.get("password"));
		
		// member값이 null이 아니면, id값을 토큰화해서 토큰을 쿠키에 넣고 응답값에 추가를 하고, 리턴해준다.
		if(member != null) {
			JwtService jwtService = new JwtServiceImpl();
			int id = member.getId();
			String token = jwtService.getToken("id", id);
			
			Cookie cookie = new Cookie("token", token);
			cookie.setHttpOnly(true);
			cookie.setPath("/");
			
			res.addCookie(cookie);
			
			// return ResponseEntity.ok().build();  // 응답값으로 토큰 임의생성값을 리턴하게끔 해준다.
			return new ResponseEntity<>(id, HttpStatus.OK);  // 응답값으로 id값으로 반환 리턴하게끔 해준다.		
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
