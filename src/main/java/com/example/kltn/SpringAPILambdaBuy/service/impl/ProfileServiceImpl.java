package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ProfileResponseDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;
import com.example.kltn.SpringAPILambdaBuy.entities.SupplierEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.ProfileRepository;
import com.example.kltn.SpringAPILambdaBuy.service.ProfileService;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public ProfileEntity findById(String id) {
		return profileRepository.findById(id).isPresent()
				? profileRepository.findById(id).get()
				: null;
	}

	@Override
	public ProfileEntity update(UpdateProfileDto updateProfileDto) {
		ProfileEntity profile = profileRepository.findById(updateProfileDto.getId()).isPresent()
									? profileRepository.findById(updateProfileDto.getId()).get()
									: null;
		if(profile != null) {
			profile.setId(updateProfileDto.getId());
			profile.setFirstName(updateProfileDto.getFirstName());
			profile.setLastName(updateProfileDto.getLastName());
			profile.setAddress(updateProfileDto.getAddress());
			profile.setAvatar(updateProfileDto.getAvatar());
			profile.setPhoneNumber(updateProfileDto.getPhoneNumber());
			profile.setUpdatedDate(new Date());
			ProfileEntity updateProfile = profileRepository.save(profile);
			return updateProfile;
		}
		return null;
	}
	
	@Override
	public ProfileEntity save(ProfileEntity profile) {
		return profileRepository.save(profile);
	}
}
