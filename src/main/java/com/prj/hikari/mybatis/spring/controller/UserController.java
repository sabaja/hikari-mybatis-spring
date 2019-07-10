package com.prj.hikari.mybatis.spring.controller;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.prj.hikari.mybatis.spring.domain.User;
import com.prj.hikari.mybatis.spring.exception.UserNotFoundException;
import com.prj.hikari.mybatis.spring.service.UserService;

@RestController
@RequestMapping(value = "/app")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	@Value("fallback.name")
	private String fallbackName;
	@Value("fallback.email")
	private String fallbackEmail;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;

	}

	@PostMapping(value = "/user")
	public ResponseEntity<Object> insertUser(@RequestBody User user) {
		this.userService.insertUser(user);
		log.info("Insert user: {}", user.getId());
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{id}")
	@HystrixCommand(commandKey = "findUserById", fallbackMethod = "defaultFindUsers", ignoreExceptions = {
			UserNotFoundException.class })
	public User findUserById(@PathVariable Integer id) throws UserNotFoundException {

		log.info("Findig user id: {}", id);
		return Optional.ofNullable(this.userService.findUserById(id))
				.orElseThrow(() -> new UserNotFoundException("User not found. ID: " + id));
	}

	@GetMapping(value = "/users", produces = "application/json")
	public ResponseEntity<List<User>> listUser() {
		List<User> users = null;
		users = this.userService.findAllUsers();
		log.info("list of users: {}", users);
		return ResponseEntity.ok(users);
	}

	@DeleteMapping(value = "/user/{id}")
	@HystrixCommand(commandKey = "findUserById", fallbackMethod = "defaultDeleteUsers", ignoreExceptions = {
			UserNotFoundException.class })
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id) throws UserNotFoundException {

		User user = Optional.ofNullable(this.userService.findUserById(id))
				.orElseThrow(() -> new UserNotFoundException("User not found. ID: " + id));
		this.userService.delete(id);
		log.info("Delete user id: {}", id);
		return ResponseEntity.ok("deleted: " + user.toString());
	}

	public User defaultFindUsers(Integer id) {
		User user = new User();
		return user;

	}
	
	public ResponseEntity<String>  defaultDeleteUsers(Integer id) {
		return ResponseEntity.ok("KO");
	}
}
