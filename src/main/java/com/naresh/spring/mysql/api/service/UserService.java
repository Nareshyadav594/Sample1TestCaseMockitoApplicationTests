package com.naresh.spring.mysql.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.spring.mysql.api.dao.UserRepository;
import com.naresh.spring.mysql.api.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	//post
	public User saveUser(User user) {
	return	 repository.save(user);
 		
	}
	//get
	public List<User> getAllUsers() {
		return repository.findAll();
		
 	}
//delete
	
	public void deleteById(int id) {
		repository.deleteById(id);
 		
	}
	
	 
	
	
	
}