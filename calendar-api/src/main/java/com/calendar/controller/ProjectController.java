package com.calendar.controller;


import com.calendar.repository.*;
import com.calendar.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.calendar.entity.Project;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectRepository repository;

    @Autowired
    private FileStorageService fileStorageService;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity createProject(@ModelAttribute Project project){
        if(repository.findByProjectName(project.getProjectName())!= null){
            return new ResponseEntity("Project Name Existed",HttpStatus.OK);
        }
        MultipartFile file  = project.getCoverFile();
        if(file!= null){
            String fileName = fileStorageService.storeFile(file, project.getProjectName());
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
        }
        project.setCoverFile(null);
        repository.save(project);
        return new ResponseEntity(project, HttpStatus.OK);
    }
    @GetMapping
    public List<Project> getAllProject(){
        List<Project> results = repository.findAll();
        return results;
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id")String id){
        Project result = repository.findByProjectName(id);
        return result;
    }

    @GetMapping("/cover/{fileName}")
    public ResponseEntity getCoverFile(@PathVariable("fileName") String fileName) throws IOException {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }
}
