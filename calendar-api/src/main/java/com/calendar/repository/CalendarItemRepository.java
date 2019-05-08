package com.calendar.repository;

import com.calendar.entity.CalendarItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarItemRepository extends MongoRepository<CalendarItem,String> {
    public List<CalendarItem> findByProjectName(String projectName);

    public CalendarItem findByProjectNameAndDate(String projectName, Date date);

    public Optional<CalendarItem> findById(String id);
}
