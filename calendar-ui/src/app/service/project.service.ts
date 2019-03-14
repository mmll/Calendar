import { Injectable } from '@angular/core';
import {Project} from '../entity/project';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  configUrl = "localhost:8080";
  constructor(private http: HttpClient) {
    this.http = http;
  }
  createProject(project: Project){
    return this.http.post(this.configUrl+"/project", project);
  }
}
