package com.example.kltn.SpringAPILambdaBuy.common.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.RegisterDto;

public class ConstantGlobal {
	public static List<RegisterDto> listAdmin = Arrays.asList(
			new RegisterDto("Toan", "Le", "lvtoan.it2000@gmail.com", "lvtoan", "123123", "123123"),
			new RegisterDto("Khang", "Dong", "duc.khang165@gmail.com", "duckhang", "123123", "123123")
		);
}
