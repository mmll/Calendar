package com.calendar.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return "uploads";
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}