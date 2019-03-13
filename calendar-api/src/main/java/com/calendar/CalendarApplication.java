package com.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.emc.ecs.sizetool.config",
//        "com.emc.ecs.sizetool.controller",
//        "com.emc.ecs.sizetool.dao",
//        "com.emc.ecs.sizetool.service"})
public class CalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }
}