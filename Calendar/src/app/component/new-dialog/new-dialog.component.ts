import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProjectService} from '../../service/project.service';

@Component({
  selector: 'app-new-dialog',
  templateUrl: './new-dialog.component.html',
  styleUrls: ['./new-dialog.component.css']
})
export class NewDialogComponent implements OnInit {
  private projectService: ProjectService
  private title;
  private description;
  constructor() {
    this.title = new FormControl("");
    this.description = new FormControl("");
  }

  ngOnInit() {
  }

  createProject(){
    this.projectService.updateProject();

  }
}
