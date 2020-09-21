package com.deepak.restfulmicroservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.restfulmicroservices.entity.UserEntity;
import com.deepak.restfulmicroservices.exceptions.UserNotFoundException;
import com.deepak.restfulmicroservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
	
	public UserEntity saveUser(UserEntity userEntity) {
		UserEntity savedUserEntity = userRepository.save(userEntity);
		return savedUserEntity;
	}
	
	public UserEntity getByUserId(Integer userId) {
		Optional<UserEntity> usereEntity =userRepository.findById(userId);
		
		if(!usereEntity.isPresent()) {
			throw new UserNotFoundException("User not found for id -> "+userId);
		}
		
		return usereEntity.get();
	}
	
	public void deleteByUserId(Integer userId) {
		userRepository.deleteById(userId);
	}
}
