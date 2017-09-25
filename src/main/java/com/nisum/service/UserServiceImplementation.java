package com.nisum.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.nisum.model.User;

@Service("userService")
public class UserServiceImplementation implements UserService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<User> userslist;

	static {

		userslist = populateDummyUsers();

	}

	@Override
	public User findById(long id) {

		for (User user : userslist) {

			if (user.getId() == id) {

				return user;

			}
		}

		return null;
	}

	@Override
	public User findByName(String name) {

		for (User user : userslist) {

			if (user.getName().equalsIgnoreCase(name)) {

				return user;

			}

		}

		return null;
	}

	@Override
	public void saveUser(User user) {

		user.setId(counter.incrementAndGet());

		userslist.add(user);

	}

	@Override
	public void updateUser(User user) {

		int index = userslist.indexOf(user);

		userslist.set(index, user);

	}

	@Override
	public void deleteUserById(long id) {

		for (Iterator<User> iterator = userslist.iterator(); iterator.hasNext();) {

			User user = iterator.next();

			if (user.getId() == id) {

				iterator.remove();
			}

		}

	}

	@Override
	public List<User> findAllUsers() {

		return userslist;

	}

	@Override
	public void deleteAllUsers() {

		userslist.clear();

	}

	@Override
	public boolean isUserExist(User user) {

		return findByName(user.getName()) != null;

	}

	private static List<User> populateDummyUsers() {

		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "Sam", 30, 70000));
		users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
		users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
		users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
		return users;

	}

}
