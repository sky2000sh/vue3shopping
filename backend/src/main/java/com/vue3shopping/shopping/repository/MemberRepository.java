package com.vue3shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vue3shopping.shopping.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	Member findByEmailAndPassword(String email, String password);

}
