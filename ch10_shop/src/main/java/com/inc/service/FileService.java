package com.inc.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String saveFile(String path, MultipartFile file) throws IllegalStateException, IOException;

}
