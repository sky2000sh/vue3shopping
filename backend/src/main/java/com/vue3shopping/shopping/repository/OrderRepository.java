package com.vue3shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vue3shopping.shopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	

}
