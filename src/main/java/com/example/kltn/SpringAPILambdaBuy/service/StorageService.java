package com.example.kltn.SpringAPILambdaBuy.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	byte[] downloadImage(String fileName);

	String uploadImage(MultipartFile file) throws IOException;

}
