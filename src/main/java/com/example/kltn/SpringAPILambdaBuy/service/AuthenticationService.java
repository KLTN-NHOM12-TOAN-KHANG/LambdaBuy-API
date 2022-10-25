package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.dto.request.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.dto.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface AuthenticationService {
	ResponseCommon<?> register(RegisterDto registerDto); 
	ResponseCommon<?> login(LoginDto loginDto);
	ResponseCommon<?> confirmToken(String token);
	void activeUser(String email);
}
