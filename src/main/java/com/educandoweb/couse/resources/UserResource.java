package com.educandoweb.couse.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.couse.entities.User;
import com.educandoweb.couse.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	private final UserService service;

	UserResource(UserService service) {
		this.service = service;
	}
	
		@GetMapping
		public ResponseEntity<List<User>> findAll(){
			List<User> List = service.findaAll();
			return ResponseEntity.ok().body(List);	
			}
		@GetMapping(value = "/{id}")
		public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		}
		
		

}
