package com.vue3shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vue3shopping.shopping.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
