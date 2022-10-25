package com.example.kltn.SpringAPILambdaBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.service.AuthenticationService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;

@RestController
@RequestMapping("/api/authentication/")
public class AuthenticationController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/register/confirm/{token_code}")
	public ResponseEntity<ResponseCommon<?>> confirm (@PathVariable("token_code") String token_code){
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.confirmToken(token_code), HttpStatus.OK);
	}
	
	@PostMapping("/register/")
	public ResponseEntity<ResponseCommon<?>> register (@RequestBody RegisterDto registerDto){
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.register(registerDto), HttpStatus.OK);
	}
	
	@PostMapping("/login/")
	public ResponseEntity<ResponseCommon<?>> login (@RequestBody LoginDto loginDto) {
		return new ResponseEntity<ResponseCommon<?>>(authenticationService.login(loginDto), HttpStatus.OK);
	}
}
