package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.dto.request.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.dto.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.dto.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface UserService {
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
	UserEntity saveUser(UserEntity user);
	UserEntity getUser(String username);
	ResponseCommon<List<UserResponseDto>> getUsers();
	ResponseCommon<?> deleteUser(String id);
}
