package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RestTemplate restTemplate;

	private List<User> users = new ArrayList<>();
	
	{
		users.add(new User(1311l, "Avinash", "12345"));
		users.add(new User(1312l, "Jay", "123"));
		users.add(new User(1314l, "Vikrant", "12"));
	}
	
	
	@Override
	public User getUser(Long userId) {
		User user = users.stream().filter(u->u.getUserId().equals(userId)).findAny().orElse(null);
		List contacts = restTemplate.getForObject(CONTACT_SERVICE_URL+userId, List.class);
		user.setContacts(contacts);
		return user;
	}

}
