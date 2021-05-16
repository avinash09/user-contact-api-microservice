package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

	private List<Contact> contacts = new ArrayList<>();

	{
		contacts.add(new Contact(1011l, "avinashjbs@gmail.com", "8689931087", 1311l));
		contacts.add(new Contact(1012l, "jayrawle@gmail.com", "9870350799", 1312l));
		contacts.add(new Contact(1014l, "vikrantlonkar07@gmail.com", "8149416469", 1314l));

	}

	@Override
	public List<Contact> getContact(Long userId) {
		log.info("getContact::userId:"+userId);
		return contacts.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
