package com.smhrd.carepose.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.smhrd.carepose.repository.MemberRepository;

@Controller
public class MainController {
	
	
	@Autowired
	MemberRepository memberRepository;

	@GetMapping("/caremain")
		public String nursmain() {
	return "monitoring";
	}

	@GetMapping("/nursmain")
	public String caremain() {
		return "dashboard";
	}
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
}