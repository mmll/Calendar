package com.calendar.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Document(collection="project")
public class Project {
    @Id
    private String id;

    private String projectName;
    private String userId;
    private String description;
    private String coverUrl;


    private Date createdTime;
    private Date updateTime;

    public Project(String projectName, String description, String coverUrl){
        this.projectName = projectName;
        this.description = description;
        this.coverUrl = coverUrl;
        this.createdTime = new Date();
        this.updateTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString(){
        return String.format(
                "Project[id=%s, projectName=%s, userId=%, description=%s, cover=%s, createdTime=%s, updateTime=%s]",
                id, projectName, userId, coverUrl, createdTime, updateTime
        );
    }
}
