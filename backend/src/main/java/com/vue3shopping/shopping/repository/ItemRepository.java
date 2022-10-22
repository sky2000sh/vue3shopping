package com.vue3shopping.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vue3shopping.shopping.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item> findByIdIn(List<Integer> ids);

}
