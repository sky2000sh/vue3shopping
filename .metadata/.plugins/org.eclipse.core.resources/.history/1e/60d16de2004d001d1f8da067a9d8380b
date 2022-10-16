package com.vue3shopping.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@GetMapping("/api/items")
	public List<String> getItems() {
		
		List<String> items = new ArrayList<>();
		items.add("premier");
		items.add("seconde");
		items.add("troisieme");
		
		return items;
		
	}

}
