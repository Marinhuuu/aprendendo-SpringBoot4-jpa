package com.educandoweb.couse.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.couse.entities.Order;
import com.educandoweb.couse.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	private final OrderService service;

	OrderResource(OrderService service) {
		this.service = service;
	}
	
		@GetMapping
		public ResponseEntity<List<Order>> findAll(){
			List<Order> List = service.findaAll();
			return ResponseEntity.ok().body(List);	
			}
		@GetMapping(value = "/{id}")
		public ResponseEntity<Order> findById(@PathVariable Long id){
			Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		}
		
		

}
