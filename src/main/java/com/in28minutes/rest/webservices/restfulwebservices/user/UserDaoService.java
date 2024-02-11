package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		return users.stream()
			.filter(user -> user.getId() == id)
			.findFirst()
			.orElseThrow(() -> new UserNotFoundException("id: " + id));
	}
	
	public User addUser(User user) {
		User newUser = new User(++usersCount, user.getName(), user.getBirthday());
		users.add(newUser);
		return newUser;
	}
}
