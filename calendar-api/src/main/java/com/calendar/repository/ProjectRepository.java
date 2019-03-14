package com.calendar.repository;

import com.calendar.entity.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface  ProjectRepository extends MongoRepository<Project,String> {
    public <List>Project findByUserId(String userId);
}
