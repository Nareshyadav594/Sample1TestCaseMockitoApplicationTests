package com.naresh.spring.mysql.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.naresh.spring.mysql.api.dao.UserRepository;
import com.naresh.spring.mysql.api.model.User;
import com.naresh.spring.mysql.api.service.UserService;

@SpringBootTest
class Sample1TestCaseMockitoApplicationTests {

	 

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepository repository;

	
	//get users
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(101, "ashish", "user")).
				collect(Collectors.toList()));
		assertEquals(1, service.getAllUsers().size());
	}

	//add users
	@Test
	public void addUserTest() {
		User user = new User(201, "bhagat", "superAdmin");

		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));
	}

	// delete user
	@Test
	public void deleteUser() {
		User user = new User(201, "bhagat", "superAdmin");
		service.deleteById(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}

}