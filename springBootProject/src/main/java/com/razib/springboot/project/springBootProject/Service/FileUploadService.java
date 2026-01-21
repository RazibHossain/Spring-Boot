package com.razib.springboot.project.springBootProject.Service;

import com.razib.springboot.project.springBootProject.Interface.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService implements IFileService {

    @Value("${app.upload.directory:${user.home}}")
    private String uploadDir;
    @Override
    public void uploadFile(MultipartFile multipartFile) {

        try {
            Thread.sleep(3000);
            Path copyLocation = Paths
                    .get( uploadDir + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename()));
            Files.copy(multipartFile.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + multipartFile.getOriginalFilename()
                    + ". Please try again!");
        }

    }
}
