package com.homedirect.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homedirect.template.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}