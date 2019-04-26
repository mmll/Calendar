package com.calendar.controller;


import com.calendar.repository.*;
import com.calendar.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import com.calendar.entity.Project;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    public Project createProject(@RequestParam  Project project, @RequestParam  MultipartFile file){
        project.setUserId("test");
        if(file!= null){
            String fileName = fileStorageService.storeFile(file, project.getProjectName());
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();
        }
        project.setCoverUrl(project.getProjectName());
        repository.save(project);
        return project;
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


}
