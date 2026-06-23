package com.educandoweb.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.couse.entities.Category;
import com.educandoweb.couse.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository repository;
	
	
		CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}
		
		public List<Category> findaAll(){
			return repository.findAll();
		}	
		
		public Category findById(Long id) {
			Optional<Category> obj = repository.findById(id);
			return obj.get();	
		}

}


