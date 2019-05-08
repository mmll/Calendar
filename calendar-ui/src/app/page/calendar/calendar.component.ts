import {Component, OnInit} from '@angular/core';
import "../../../assets/calendar-heatmap";
import {Project} from '../../entity/project';
import {FormControl} from '@angular/forms';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {switchMap} from 'rxjs/operators';
import {CalendarService} from '../../service/calendar.service';
import {ProjectService} from '../../service/project.service';
import {of} from "rxjs";
import {CalendarItem} from "../../entity/calendarItem";
import {TIMEOUT} from "dns";

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
	private projectId;
	private calendarItems;
	private todayItem: CalendarItem;
	private chartData;

	constructor(private route: ActivatedRoute, private calendarService: CalendarService, private projectService: ProjectService) {
		this.route = route;
		this.calendarService = calendarService;
		this.projectService = projectService;
		this.todayItem = new CalendarItem("", null, null, false);
		this.project = new Project(null, null, null);
	}

	ngOnInit() {
		let today = new Date();
		this.comment = new FormControl();
		this.date = today.toDateString();
		this.route.paramMap.pipe(
			switchMap((params: ParamMap) =>
				of(params.get('id'))
			)
		).subscribe((d) => {
			this.projectId = d;
		});

		this.projectService.getProjectByName(this.projectId).subscribe(res => {
			this.chartData = [];
			this.project = res;
			this.calendarService.getCalendarItem(this.projectId).subscribe(res => {
				this.calendarItems = res;
				this.calendarItems.forEach(item => {
					let date = new Date(Date.parse(item.date));
					if (date.toDateString() == today.toDateString()) {
						this.comment.setValue(item.content);
						this.todayItem = new CalendarItem(item.projectName, item.date, item.content, item.checked);
						this.todayItem.setId(item.id);
					}
					this.chartData.push({data: new Date(date), count: 5})
				});


				let chart1 = calendarHeatmap()
					.data(this.chartData)
					.selector('#calendar')
					.colorRange(['#D8E6E7', '#218380'])
					.tooltipEnabled(true)
					.onClick(function (data) {
						console.log('onClick callback. Data:', data);
					})
					.locale(locale);
				chart1();
			});
		})
	}

	checkItem() {
		if (this.todayItem.getId()) {
			this.todayItem.setContent(this.comment.value);
			this.calendarService.checkCalendarItem(this.todayItem).subscribe(resp => {
				this.ngOnInit();
			});
		}
		else
			{
				let calendarItem = new CalendarItem(this.projectId, new Date(), this.comment.value, true);
				this.calendarService.checkCalendarItem(calendarItem).subscribe(resp => {
					this.ngOnInit();
				})
			}
		}

}
