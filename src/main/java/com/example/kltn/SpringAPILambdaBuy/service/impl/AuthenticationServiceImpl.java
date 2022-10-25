package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
import com.example.kltn.SpringAPILambdaBuy.repository.UserRepository;
import com.example.kltn.SpringAPILambdaBuy.security.PasswordEncoder;
import com.example.kltn.SpringAPILambdaBuy.service.AuthenticationService;
import com.example.kltn.SpringAPILambdaBuy.service.CartService;
import com.example.kltn.SpringAPILambdaBuy.service.ConfirmationTokenService;
import com.example.kltn.SpringAPILambdaBuy.service.CustomerService;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;
import com.example.kltn.SpringAPILambdaBuy.validator.EmailValidator;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailValidator emailValidator;
	
	List<UserResponseDto> listUserDto = new ArrayList<>();
	
	
	@Override
	public ResponseCommon<?> register(RegisterDto registerDto) {
		if(!registerDto.getPassword().equals(registerDto.getRePassword())) {
			return new ResponseCommon<>(400, false, "PASSWORD_NOT_EQUAL");
		}
		boolean isValidEmail = emailValidator.test(registerDto.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("Email not valid");
		}
		UserEntity userMail = userService.findByEmail(registerDto.getEmail());
		if(userMail != null) {
			return new ResponseCommon<>(400, false, "EMAIL_EXIST");
		}
		UserEntity userName = userService.findByUsername(registerDto.getUsername());
		if(userName != null) {
			return new ResponseCommon<>(400, false, "USERNAME_EXIST");
		}
		String encodePassword = bCryptPasswordEncoder.encode(registerDto.getPassword());
		UserEntity createUser = new UserEntity(registerDto.getUsername(), registerDto.getEmail(), encodePassword, UserRole.CUSTOMER, new Date(), registerDto.getFirstName() + " " + registerDto.getLastName());
		userService.saveUser(createUser);
		
		CustomerEntity customer = new CustomerEntity(registerDto.getFirstName(), registerDto.getLastName(), createUser);
		customerService.save(customer);
		
		CartEntity cart = new CartEntity(0, false, customer);
		cartService.save(cart);
		
		createUser.setCustomer(null);
		createUser.setAdmin(null); 
		
		// Send confirmation token
		String token = UUID.randomUUID().toString();
		ConfirmationTokenEntity createToken = new ConfirmationTokenEntity(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), createUser);
		confirmationTokenService.saveConfirmationToken(createToken);
		
		// Send mail
		
		
		UserResponseDto userDto = new UserResponseDto(createUser.getId(), createUser.getEmail(), createUser.getUsername(), createUser.getPassword(), createUser.getRole(),  createUser.getCreatedDate(), createUser.getCreatedBy(), createUser.getUpdatedDate(), createUser.getUpdatedBy());
		return new ResponseCommon<>(200, true, "REGISTER_SUCCESS", createToken.toString());
	}
	

	@Override
	public ResponseCommon<?> login(LoginDto loginDto) {
		UserEntity userName = userService.findByUsername(loginDto.getUsername());
		if(userName != null) {
			if(userName.isEnabled() == true) {
				if(bCryptPasswordEncoder.matches(loginDto.getPassword(), userName.getPassword())) {
					UserResponseDto userDto = new UserResponseDto(userName.getId(), userName.getEmail(), userName.getUsername(), userName.getPassword(), userName.getRole(), userName.getCreatedDate(), userName.getCreatedBy(), userName.getUpdatedDate(), userName.getUpdatedBy());
					return new ResponseCommon<>(200, true, "LOGIN_SUCCESS", userDto);
				} else {
					return new ResponseCommon<>(400, false, "USERNAME_OR_PASSWORD_NOT_TRUE");
				}
			} else {
				return new ResponseCommon<>(400, false, "ACCOUNT_NOT_ACTIVE");
			}
			
		}
		UserEntity userEmail = userService.findByEmail(loginDto.getEmail());
		if(userEmail != null) {
			if(userEmail.isEnabled() == true) {
				if(bCryptPasswordEncoder.matches(loginDto.getPassword(), userEmail.getPassword())) {
					UserResponseDto userDto = new UserResponseDto(userEmail.getId(), userEmail.getEmail(), userEmail.getUsername(), userEmail.getPassword(), userEmail.getRole(), userEmail.getCreatedDate(), userEmail.getCreatedBy(), userEmail.getUpdatedDate(), userEmail.getUpdatedBy());
					return new ResponseCommon<>(200, true, "LOGIN_SUCCESS", userDto);
				} else {
					return new ResponseCommon<>(400, false, "EMAIL_OR_PASSWORD_NOT_TRUE");
				}
			} else {
				return new ResponseCommon<>(400, false, "ACCOUNT_NOT_ACTIVE");
			}
		}
		return new ResponseCommon<>(400, false, "USER_NOT_EXIST");
	}
	
	@Transactional
	public ResponseCommon<?> confirmToken(String token) {
		ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenService.getToken(token);
		if(confirmationTokenEntity.getConfirmDate() != null) {
			throw new IllegalStateException("EMAIL_ALREADY_CONFIRMED");
		}
		LocalDateTime expiredDate = confirmationTokenEntity.getExpiresDate();
		if(expiredDate.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("TOKEN_EXPIRED");
//			return new ResponseCommon<>(400, false, "TOKEN_EXPIRED");
		}
		confirmationTokenService.setConfirmedDate(token);
		activeUser(confirmationTokenEntity.getUser().getEmail());
		
		return new ResponseCommon<>(200, true, "CONFIRM_SUCCESS");
	}


	@Override
	public void activeUser(String email) {
		try {
			UserEntity user = userService.findByEmail(email);
			user.setEnabled(true);
			userService.saveUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
