package com.example.demo.service;

import com.example.demo.dao.entity.SupplierFile;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	SupplierFile uploadContract(MultipartFile multipartFile[]) throws Exception;
	SupplierFile getUrl();
	// String uploadPicture(MultipartFile multipartFile[])throws Exception;

}
