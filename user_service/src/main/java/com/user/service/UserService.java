package com.user.service;

import com.user.entity.User;

public interface UserService {
	
	public static final String CONTACT_SERVICE_URL = "http://CONTACT-SERVICE/contact/user/";

	public User getUser(Long userId);
}
