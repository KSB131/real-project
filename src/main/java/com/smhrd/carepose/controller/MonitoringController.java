package com.smhrd.carepose.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MonitoringController {
	
	@GetMapping("/monitoring")
	public String monitoring() {
		return "monitoring";
	}

}
