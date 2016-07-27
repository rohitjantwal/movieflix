package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.User;
import io.egen.rest.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {
	 
	@Autowired 
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return service.findAll();
	}
	//3producing JSon
	 //extract value out of path={id} and put it in string id
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findByUserId(@PathVariable("id") String id) {
		return service.findByUserId(id);
	}
	//5producing JSon
	@RequestMapping(method = RequestMethod.GET, path = "{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findByEmailId(@PathVariable("email") String email){
		return service.findByEmailId(email);	
	}
	/*login
	@RequestMapping(method = RequestMethod.GET, path = "{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findUserByEmailAndPassword(@PathVariable("password") String password, @PathVariable("email") String email){
			System.out.println(email);
		 return service.findUserByEmailAndPassword(email,password);		 
	}*/
	//1producing and consuming JSon, spring reads Json from @RequestBody and transform it into java "user" object, if it fails to to do it give 400 error
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	//6producing and consuming JSon, spring reads Json from @RequestBody
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}
	//7
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
}
