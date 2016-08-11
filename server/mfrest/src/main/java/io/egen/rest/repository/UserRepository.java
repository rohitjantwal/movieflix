package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserRepository {
	
	public List<User> findAll();

	public User findByUserId(String id);

	public User findByEmailId(String email);

	public User create(User user);

	public User update(User user);

	public void delete(User user);

}
