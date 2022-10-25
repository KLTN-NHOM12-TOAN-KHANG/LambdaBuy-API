package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.dto.request.LoginDto;
import com.example.kltn.SpringAPILambdaBuy.dto.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.dto.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.CartEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ConfirmationTokenEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.CustomerEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.UserRole;
import com.example.kltn.SpringAPILambdaBuy.entities.UserStatus;
import com.example.kltn.SpringAPILambdaBuy.repository.UserRepository;
import com.example.kltn.SpringAPILambdaBuy.service.CartService;
import com.example.kltn.SpringAPILambdaBuy.service.ConfirmationTokenService;
import com.example.kltn.SpringAPILambdaBuy.service.CustomerService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;
import com.example.kltn.SpringAPILambdaBuy.validator.EmailValidator;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailValidator emailValidator;
	
	List<UserResponseDto> listUserDto = new ArrayList<>();
	
	
	@Override
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserEntity getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public ResponseCommon<List<UserResponseDto>> getUsers() {
		List<UserEntity> listUser = userRepository.findAll();
		for (UserEntity userEntity : listUser) {
			UserResponseDto userDto = new UserResponseDto(userEntity.getId(), userEntity.getEmail(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole(), userEntity.getCreatedDate(), userEntity.getCreatedBy(), userEntity.getUpdatedDate(), userEntity.getUpdatedBy());
			listUserDto.add(userDto);
		}
		return new ResponseCommon<>(200, true, "SUCCESS", listUserDto);
	}

	

	@Override
	public ResponseCommon<?> deleteUser(String id) {
		UserEntity user = userRepository.getById(id);
		if(user != null) {
			userRepository.deleteById(id);
			return new ResponseCommon<>(200, true, "DELETE_SUCCESS");
		}
		return new ResponseCommon<>(400, false, "USER_NOT_EXIST");
	}
}
