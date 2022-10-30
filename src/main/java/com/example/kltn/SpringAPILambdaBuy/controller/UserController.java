package com.example.kltn.SpringAPILambdaBuy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.kltn.SpringAPILambdaBuy.common.request.RegisterDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.common.response.UserResponseDto;
import com.example.kltn.SpringAPILambdaBuy.entities.UserEntity;
import com.example.kltn.SpringAPILambdaBuy.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private static final String APPLICATION_JSON_VALUE = "application/json";
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<ResponseCommon<List<UserResponseDto>>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/user/name/{username}")
	public ResponseEntity<ResponseCommon<UserResponseDto>> getUserByUsername(@PathVariable("username") String username){
		UserEntity user = userService.findByUsername(username);
		UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy());
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SUCCESS", userDto));
	}
	
	@GetMapping("/user/email/{email}")
	public ResponseEntity<ResponseCommon<UserResponseDto>> getUserByEmail(@PathVariable("email") String email){
		UserEntity user = userService.findByEmail(email);
		UserResponseDto userDto = new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy());
		return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SUCCESS", userDto));
	}
	
	@PostMapping("/user/save")
	public ResponseEntity<ResponseCommon<?>> saveUser(@RequestBody UserEntity user) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
		userService.saveUser(user);
		return ResponseEntity.created(uri).body(new ResponseCommon<>(200, true, "SAVE_USER_SUCCESS"));
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<ResponseCommon<?>> deleteUser(@RequestParam("id") String id){
		return new ResponseEntity<ResponseCommon<?>>(userService.deleteUser(id), HttpStatus.OK);
	} 
}
