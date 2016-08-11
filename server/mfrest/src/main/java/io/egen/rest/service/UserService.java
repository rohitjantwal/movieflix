package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserService {
	
	public List<User> findAll();

	public User findByUserId(String id);
	
	public User findByEmailId(String email);

	public User create(User user);

	public User update(String id, User user);

	public void delete(String id);
}
