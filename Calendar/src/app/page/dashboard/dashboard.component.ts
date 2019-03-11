import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {NewDialogComponent} from '../../component/new-dialog/new-dialog.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }
  openDialog(){
    const dialogRef = this.dialog.open(NewDialogComponent)
    dialogRef.afterClosed().subscribe(()=>{

    })
  }

}
