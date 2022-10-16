package com.vue3shopping.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vue3shopping.shopping.entity.Item;
import com.vue3shopping.shopping.repository.ItemRepository;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/api/items")
	public List<Item> getItems() {
		
//		List<String> items = new ArrayList<>();
//		items.add("premier");
//		items.add("seconde");
//		items.add("troisieme");
		
		List<Item> items = itemRepository.findAll();
		
		return items;		
	}

}
