import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProjectService} from '../../service/project.service';
import {Project} from '../../entity/project';

@Component({
  selector: 'app-new-dialog',
  templateUrl: './new-dialog.component.html',
  styleUrls: ['./new-dialog.component.css']
})
export class NewDialogComponent implements OnInit {
  private projectService: ProjectService
  private formGroup;
  constructor(projectService: ProjectService) {
    this.formGroup = new FormGroup({
      title:new FormControl("",[Validators.required,]),
      description: new FormControl("")
    });
    this.projectService = projectService;
  }

  ngOnInit() {
  }

  createProject(){
    let project = new Project(this.formGroup.get("title").value, this.formGroup.get("description").value, 'test');
    this.projectService.createProject(project)
      .subscribe(resp =>{

      });

  }
}
