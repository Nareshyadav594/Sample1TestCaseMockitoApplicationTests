package com.naresh.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.spring.mysql.api.model.User;
import com.naresh.spring.mysql.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	  private UserService  service;  
	
	@PostMapping("/adduser")
	public User save(@RequestBody User user) {
		return service.saveUser(user);
		
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers() {
		return service.getAllUsers();
		
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable int id) {
		  service.deleteById(id);
	}

}
