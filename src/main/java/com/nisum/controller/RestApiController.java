package com.nisum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.model.User;
import com.nisum.service.UserService;

@RestController
public class RestApiController {

	private UserService userService;

	/* Retrieve All User */

	@RequestMapping("/user")
	public List<User> getAllUser() {

		return userService.findAllUsers();

	}

	/* Retrieve Single User By Id */

	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable long id) {

		return userService.findById(id);

	}

	/* Retrieve Single User By Name */

	@RequestMapping("/user/{name}")
	public User getUserByName(@PathVariable String name) {

		return userService.findByName(name);

	}

	/* Update a User */

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable long id, @RequestBody User user) {

		User currentUser = userService.findById(id);

		currentUser.setName(user.getName());

		currentUser.setAge(user.getAge());

		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);

		return;

	}

	/* Create a User */

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void saveUser(User user) {

		userService.saveUser(user);

	}

	/* Delete a User */

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {

		userService.deleteUserById(id);

	}

	/* Delete All Users */

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public void deleteUser() {

		userService.deleteAllUsers();

	}

}
