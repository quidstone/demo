package com.test.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
public class Demo {

    @Autowired
    private PeopleService peopleService;

    @Scheduled(initialDelay = 5000L, fixedDelay = 1000L)
    private void perMinuteStatsTask() {
        try {
            System.out.println("adding people");
            peopleService.addPeople();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
