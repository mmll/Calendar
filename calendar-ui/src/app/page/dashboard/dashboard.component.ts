import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {NewDialogComponent} from '../../component/new-dialog/new-dialog.component';
import {ProjectService} from '../../service/project.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private projectService;
  private projects;
  constructor(public dialog: MatDialog, projectService: ProjectService) {
    this.projectService = projectService;
  }

  ngOnInit() {
    this.projectService.getAllProject().subscribe(res => {
      this.projects = res;
      this.projects.forEach( project => {
	       project.image = 'http://localhost:8080' + '/project/cover/' + project.projectName;
        // this.projectService.getCoverByName(project.projectName).subscribe( response => {
        //   project.image = response;
        //   });
        });
    });
  }

  openDialog() {
    const dialogRef = this.dialog.open(NewDialogComponent, { width: '50vw'})
    const sub = dialogRef.componentInstance.onAdd.subscribe(() => {
	    dialogRef.close();
	    this.ngOnInit();
    });

    dialogRef.afterClosed().subscribe(() => {
    });
  }

}
