import { Injectable } from '@angular/core';
import {Project} from '../entity/project';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  configUrl = "http://localhost:8080";
  constructor(private http: HttpClient) {
    this.http = http;
  }

  createProject(project: Project){
    const formData = new FormData();
    formData.append('projectName', project.getProjectName());
    formData.append('description', project.getDescription());
    formData.append('coverFile', project.getCoverFile());
    return this.http.post(this.configUrl+"/project", formData,{responseType: 'text'});
  }

  getAllProject(){
    return this.http.get(this.configUrl+"/project");
  }

  getProjectByName(projectName:String){
    return this.http.get<Project>(this.configUrl+"/project"+"/"+projectName)
  }
}
