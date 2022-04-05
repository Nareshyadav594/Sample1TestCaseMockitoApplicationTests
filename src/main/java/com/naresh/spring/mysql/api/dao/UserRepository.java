package com.naresh.spring.mysql.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naresh.spring.mysql.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
