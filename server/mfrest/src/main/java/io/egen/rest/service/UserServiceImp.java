package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.User;
import io.egen.rest.exception.UserAlreadyExistsException;
import io.egen.rest.exception.UserNotFoundException;
import io.egen.rest.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll(); 
	}

	@Override
	public User findByUserId(String id) {
		User existing = repository.findByUserId(id);
		if(existing == null) {
			throw new UserNotFoundException("User with id " + id + " not found.");
		} 
		return existing;
	}

	@Override
	public User findByEmailId(String email) {
		User existing = repository.findByEmailId(email);
		if(existing == null) {
			throw new UserNotFoundException("User with email "+ email + " not found.");
		}
		return null;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmailId(user.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findByUserId(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findByUserId(id);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		repository.delete(existing);
	}

}
