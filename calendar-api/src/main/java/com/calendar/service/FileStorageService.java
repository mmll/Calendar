package com.calendar.service;

import com.calendar.property.FileStorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    private Path fileStorageLocation;

    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            //throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                //throw  new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLOcation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLOcation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex){
            //throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            return "";
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                //throw new MyFileNotFoundException("File not found " + fileName);
                return null;
            }
        } catch (MalformedURLException ex) {
            //throw new MyFileNotFoundException("File not found " + fileName, ex);
            return null;
        }
    }
}
