import { Component, OnInit } from '@angular/core';
import "../../../assets/calendar-heatmap";
import {Project} from '../../entity/project';
import {FormControl} from '@angular/forms';

declare var calendarHeatmap: any;

const locale = {
  months: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
  days: ['S', 'M', 'T', 'W', 'T', 'F', 'S'],
  No: 'No',
  on: 'on',
  Less: 'Less',
  More: 'More'
};

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})

export class CalendarComponent implements OnInit {
  private chart1;
  private project: Project;
  private comment;
  private date;
  constructor() { }

  ngOnInit() {
    this.project = new Project('test title',"test description", "test cover url");
    this.comment = new FormControl();
    let today = new Date();
    this.date = today.getFullYear()+'-'+today.getMonth()+'-'+today.getDay();
    const chartData = [{
      date: new Date(2018, 11, 12),
      count: 1
    },
      {
        date: new Date(2018, 11, 13),
        count: 5
      },
      {
        date: new Date(2018, 11, 14),
        count: 6
      }];
    let chart1 = calendarHeatmap()
      .data(chartData)
      .selector('#calendar')
      .colorRange(['#D8E6E7', '#218380'])
      .tooltipEnabled(true)
      .onClick(function (data) {
        console.log('onClick callback. Data:', data);
      })
      .locale(locale);
    chart1();
  }

}
