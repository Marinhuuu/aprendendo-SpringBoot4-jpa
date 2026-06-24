package com.educandoweb.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.couse.entities.Product;
import com.educandoweb.couse.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;
	
	
		ProductService(ProductRepository repository) {
		this.repository = repository;
	}
		
		public List<Product> findaAll(){
			return repository.findAll();
		}	
		
		public Product findById(Long id) {
			Optional<Product> obj = repository.findById(id);
			return obj.get();	
		}

}


