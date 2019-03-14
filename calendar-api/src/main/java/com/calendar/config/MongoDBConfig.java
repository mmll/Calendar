package com.calendar.config;

import com.calendar.repository.*;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.config.*;
import org.springframework.data.mongodb.repository.config.*;

@Configuration
@EnableMongoRepositories(basePackages = "com.calendar")
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName(){
        return "calendar";
    }


    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

}
