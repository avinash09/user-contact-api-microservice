package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@Autowired
    private Environment env;

	@Value("${server.port}")
	private String vcontactServiceUri;

	@RequestMapping("/contact-service-uri")
	public String getuserServiceUrl() {
		String contactServiceUri = env.getProperty("contact.service.uri");
		System.out.println("contactServiceUri:"+contactServiceUri);
		return contactServiceUri;
	}

}
