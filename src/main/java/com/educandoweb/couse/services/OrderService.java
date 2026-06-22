package com.educandoweb.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.couse.entities.Order;
import com.educandoweb.couse.repositories.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository repository;
	
	
		OrderService(OrderRepository repository) {
		this.repository = repository;
	}
		
		public List<Order> findaAll(){
			return repository.findAll();
		}	
		
		public Order findById(Long id) {
			Optional<Order> obj = repository.findById(id);
			return obj.get();	
		}

}


