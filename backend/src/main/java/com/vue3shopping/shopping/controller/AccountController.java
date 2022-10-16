package com.vue3shopping.shopping.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue3shopping.shopping.entity.Member;
import com.vue3shopping.shopping.repository.MemberRepository;

@RestController
public class AccountController {
	
	@Autowired
	MemberRepository memberRepository;
	
	// 아래 post로 데이터를 요청 받는데, 인자값을 param으로 받고 그 안에 email, password를 던져서 id 값을 리턴해준다.
	@PostMapping("/api/account/login")
	public int login(@RequestBody Map<String, String> param) {
		
		Member member = memberRepository.findByEmailAndPassword(param.get("email"), param.get("password"));
		
		if(member != null) {
			return member.getId();
		}
		
		return 0;		
	}

}