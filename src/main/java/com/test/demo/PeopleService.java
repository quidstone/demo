package com.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PeopleService {
    
    @Autowired
    private PeopleRepository peopleRepository;

    @Retryable(value = {Exception.class}, maxAttempts = 3, 
        backoff = @Backoff(delay = 200), listeners = {"retryListener"})
    public void addPeople() throws Exception{
        People p = new People(20, "James", "bond");
        peopleRepository.save(p);
    }
    
}
