package com.calendar.controller;


import com.calendar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.calendar.entity.Project;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/project")
public class ProjectController {
    private ProjectRepository repository;

    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/project", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project){
        project.setUserId("test");
        repository.save(project);
        return project;
    }
}
