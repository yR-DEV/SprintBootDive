package com.personal.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This annotation combines @controller and @response body
// and eliminates the need to annotate every request handling method
// of this class with the @ResponseBody annotation
@RestController
public class BasicController {

	// Maps all requests to the base url '/' to this method: getHomeMessage()
	@RequestMapping("/")
	public String getHomeMessage() {
		return "Grettings from base url!";
	}
	
}
