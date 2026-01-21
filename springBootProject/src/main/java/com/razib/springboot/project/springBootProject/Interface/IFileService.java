package com.razib.springboot.project.springBootProject.Interface;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    public void uploadFile(MultipartFile multipartFile);
}
