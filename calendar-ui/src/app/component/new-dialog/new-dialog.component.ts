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
  private imageSrc: any;
  private fileToUpload: File = null;
  constructor(projectService: ProjectService) {
    this.formGroup = new FormGroup({
      title:new FormControl("",[Validators.required,]),
      description: new FormControl(""),
    });
    this.projectService = projectService;
  }
  ngOnInit() {

  }

  createProject(){
    let project = new Project(this.formGroup.get("title").value, this.formGroup.get("description").value, this.fileToUpload);
    this.projectService.createProject(project)
      .subscribe(resp =>{
      });

  }

  preview(files: any): void {
    if (files.length === 0)
      return;
    const reader = new FileReader();
    reader.readAsDataURL(files[0]);
    this.fileToUpload = files[0];
    reader.onload = () => {
      this.imageSrc = reader.result;
    }

  }
}
