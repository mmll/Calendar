package com.calendar.controller;


import com.calendar.repository.*;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.calendar.entity.Project;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    public Project createProject(@RequestBody Project project){
        project.setUserId("test");
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
