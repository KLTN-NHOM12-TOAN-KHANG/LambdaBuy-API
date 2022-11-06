package com.example.kltn.SpringAPILambdaBuy.service;

import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.CreateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.request.user.UpdateUserDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;

public interface UserService {
	UserEntity findById(String id);
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
	void saveUser(UserEntity user);
	UserResponseDto createUser(CreateUserDto createUserDto);
	UserResponseDto updateUser(UpdateUserDto updateuserDto);
//	UserResponseDto updateUserAndProfile(UpdateUserProfileDto updateUserDto);
	UserEntity getUser(String username);
	ResponseCommon<List<UserResponseDto>> getUsers();
	ResponseCommon<?> deleteUser(String id);
}
