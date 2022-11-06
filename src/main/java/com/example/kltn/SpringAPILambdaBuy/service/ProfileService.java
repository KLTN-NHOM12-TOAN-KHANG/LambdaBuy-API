package com.example.kltn.SpringAPILambdaBuy.service;

import com.example.kltn.SpringAPILambdaBuy.common.request.profile.UpdateProfileDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.ResponseCommon;
import com.example.kltn.SpringAPILambdaBuy.entities.ProfileEntity;

public interface ProfileService {
	ProfileEntity findById(String id);
	ProfileEntity update(UpdateProfileDto updateProfileDto);
	ProfileEntity save(ProfileEntity profile);
}
