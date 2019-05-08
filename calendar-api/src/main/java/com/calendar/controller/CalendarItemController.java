package com.calendar.controller;

import com.calendar.entity.CalendarItem;
import com.calendar.repository.CalendarItemRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendarItem")
public class CalendarItemController {
    private CalendarItemRepository repository;

    public CalendarItemController(CalendarItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity checkCalendarItem(@RequestBody CalendarItem calendarItem){

        if(calendarItem.getId()!= null){
            CalendarItem item = repository.findById(calendarItem.getId()).get();
            item.setContent(calendarItem.getContent());
            repository.save(item);
        }
        else{
            repository.save(calendarItem);
        }
        return new ResponseEntity(calendarItem, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity getCalendarItemByProjectName(@PathVariable("id")String id){
        List<CalendarItem> results = repository.findByProjectName(id);
        return new ResponseEntity(results, HttpStatus.OK);
    }
}
