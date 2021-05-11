package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.user.entity.User;

@Service
@RefreshScope
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${microservices.contact.endpoint.uri}")
	private String CONTACT_SERVICE_URL;

	private List<User> users = new ArrayList<>();
	
	{
		users.add(new User(1311l, "Avinash", "12345"));
		users.add(new User(1312l, "Jay", "123"));
		users.add(new User(1314l, "Vikrant", "12"));
	}
	
	
	@Override
	@HystrixCommand(fallbackMethod="getUserFallBack")
	public User getUser(Long userId) {
		User user = users.stream().filter(u->u.getUserId().equals(userId)).findAny().orElse(null);
		List contacts = restTemplate.getForObject(CONTACT_SERVICE_URL+userId, List.class);
		user.setContacts(contacts);
		return user;
	}
	
	public User getUserFallBack(Long userId) {
		return new User();
	}
}
