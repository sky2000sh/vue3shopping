package com.vue3shopping.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vue3shopping.shopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findByMemberIdOrderByIdDesc(int memberId);

}
