package com.apigateway.fallback;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	@RequestMapping("/userFallBack")
	public Mono<String> userServiceFallBack(){
		return Mono.just("User Service is taking too long to respond or is down. Please try again later");
	}

	@RequestMapping("/contactFallBack")
	public Mono<String> contactServiceFallBack(){
		return Mono.just("Contact Service is taking too long to respond or is down. Please try again later");
	}

}
