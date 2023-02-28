package com.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.extensions.compactnotation.PackageCompactConstructor;

import com.com.springboot.JwtUtil;
import com.com.springboot.entity.AuthRequest;

@RestController
public class welcomeController {
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String getMsg() {
		
		
		return "wel come penchala kona";
	}
	
	@PostMapping("authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		
		
		authenticationManager.authenticate(  new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		
		return jwtUtil.generateToken(authRequest.getUserName()) ;
	}
}
