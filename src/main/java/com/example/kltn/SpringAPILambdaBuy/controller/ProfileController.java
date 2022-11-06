package com.example.kltn.SpringAPILambdaBuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ProductEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.service.ProfileService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseCommon<?>> findById(@PathVariable("id") String id) {
		ProfileEntity profile = profileService.findById(id);
		if(profile != null) {
			ProfileResponseDto profileResponseDto = new ProfileResponseDto(profile.getId(), profile.getPhoneNumber(), profile.getAddress(), profile.getAvatar(), profile.getFirstName(), profile.getLastName());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "FIND_PROFILE_SUCCESS", profileResponseDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "PROFILE_NOT_FOUND"));
	}

	@PutMapping("/")
	public ResponseEntity<ResponseCommon<?>> updateProfile(@RequestBody UpdateProfileDto updateProfileDto) {
		ProfileEntity profileEntity = profileService.update(updateProfileDto);
		if(profileEntity != null) {
			ProfileResponseDto profileResponseDto = new ProfileResponseDto(profileEntity.getId(), profileEntity.getPhoneNumber(), profileEntity.getAddress(), profileEntity.getAvatar(), profileEntity.getFirstName(), profileEntity.getLastName());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "UPDATE_PROFILE_SUCCESS", profileResponseDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "UPDATE_PROFILE_FAIL"));
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseCommon<?>> save(ProfileEntity profile) {
		ProfileEntity profileEntity = profileService.save(profile);
		if(profileEntity != null) {
			ProfileResponseDto profileResponseDto = new ProfileResponseDto(profileEntity.getId(), profileEntity.getPhoneNumber(), profileEntity.getAddress(), profileEntity.getAvatar(), profileEntity.getFirstName(), profileEntity.getLastName());
			return ResponseEntity.ok().body(new ResponseCommon<>(200, true, "SAVE_PROFILE_SUCCESS", profileResponseDto));
		}
		return ResponseEntity.badRequest().body(new ResponseCommon<>(400, false, "SAVE_PROFILE_FAIL"));
	}
}
