package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface UserService {
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
	UserEntity saveUser(UserEntity user);
	UserEntity getUser(String username);
	ResponseCommon<List<UserResponseDto>> getUsers();
	ResponseCommon<?> deleteUser(String id);
}
