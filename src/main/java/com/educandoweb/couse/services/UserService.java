package com.educandoweb.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educandoweb.couse.entities.User;
import com.educandoweb.couse.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repository;
	
	
		UserService(UserRepository repository) {
		this.repository = repository;
	}
		
		public List<User> findaAll(){
			return repository.findAll();
		}	
		
		public User findById(Long id) {
			Optional<User> obj = repository.findById(id);
			return obj.get();	
		}

}


