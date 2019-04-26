package com.calendar;

import com.calendar.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@ComponentScan({
        "com.calendar.controller",
        "com.calendar.config",
        "com.calendar.entity",
        "com.calendar.repository",
        "com.calendar.service",
        "com.calendar.exception",})
public class CalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }
}