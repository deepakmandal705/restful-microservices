package com.deepak.restfulmicroservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deepak.restfulmicroservices.entity.UserEntity;
import com.deepak.restfulmicroservices.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "users")
	public List<UserEntity> getAllUser(){
		return userService.getAllUsers();
	}
	
	//Create and return the created URI
	@PostMapping(value = "users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserEntity userEntity){
		UserEntity savedUserEntity = userService.saveUser(userEntity);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUserEntity.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "users/{userId}")
	public UserEntity getUserById(@PathVariable Integer userId) {
		return userService.getByUserId(userId);
	}
	
	@DeleteMapping(value = "users/{userId}")
	public void deleteUserById(@PathVariable Integer userId) {
		userService.deleteByUserId(userId);
	}
	
}
