import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CalendarItem} from "../entity/calendarItem";

@Injectable({
  providedIn: 'root'
})
export class CalendarService {
	configUrl = "http://localhost:8080";
  constructor(private http: HttpClient) {
    this.http = http;
  }

  getCalendarItem(id: string){
	  return this.http.get<CalendarItem>(this.configUrl + '/calendarItem/' + id);
  }

  checkCalendarItem(calendarItem: CalendarItem){
    return this.http.post(this.configUrl + '/calendarItem', calendarItem);
  }
}
