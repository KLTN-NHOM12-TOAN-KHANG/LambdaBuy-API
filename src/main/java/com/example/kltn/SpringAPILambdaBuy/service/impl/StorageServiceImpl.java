package com.example.kltn.SpringAPILambdaBuy.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.kltn.SpringAPILambdaBuy.entities.ImageEntity;
import com.example.kltn.SpringAPILambdaBuy.repository.StorageRepository;
import com.example.kltn.SpringAPILambdaBuy.service.StorageService;
import com.example.kltn.SpringAPILambdaBuy.utils.ImageUtil;

@Service
public class StorageServiceImpl implements StorageService {
	@Autowired
	private StorageRepository storageRepository;
	
	@Override
	public String uploadImage(MultipartFile file) throws IOException {
		ImageEntity img = new ImageEntity();
		img.setName(Math.random() + file.getOriginalFilename());
		img.setType(file.getContentType());
		img.setImageData(ImageUtil.compressImage(file.getBytes()));
		
		ImageEntity createImage = storageRepository.save(img);
		if(createImage != null) {
			return "File uploaded successfully: " + file.getOriginalFilename();
		}
		return null;
	}
	
	@Override
	public byte[] downloadImage(String fileName) {
        Optional<ImageEntity> dbImage = storageRepository.findByName(fileName);
        byte[] images = ImageUtil.decompressImage(dbImage.get().getImageData());
        return images;
    }


//    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
//        String filePath=FOLDER_PATH+file.getOriginalFilename();
//
//        FileEn fileData=fileDataRepository.save(FileData.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .filePath(filePath).build());
//
//        file.transferTo(new File(filePath));
//
//        if (fileData != null) {
//            return "file uploaded successfully : " + filePath;
//        }
//        return null;
//    }
//
//    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
//        String filePath=fileData.get().getFilePath();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }
}
