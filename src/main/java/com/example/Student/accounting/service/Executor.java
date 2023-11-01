package com.example.Student.accounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class Executor {

    private final StudentAccountService service;

    @EventListener(ApplicationStartedEvent.class)
    public void execution() {
       service.createStudent(2);
    }
}
