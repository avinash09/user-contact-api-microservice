package com.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

	@RequestMapping("/contactFallBack")
	public String getcontactFallBack() {
		return "Contact Service is down or taking to long time for response";
	}
	
	@RequestMapping("/userFallBack")
	public String getuserFallBack() {
		return "Contact Service is down or taking to long time for response";
	}
}
