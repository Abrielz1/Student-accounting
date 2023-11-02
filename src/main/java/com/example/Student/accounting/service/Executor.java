package com.example.Student.accounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RequiredArgsConstructor
public class Executor {

    private final StudentAccountService service;

    @EventListener(ApplicationStartedEvent.class)
    public void execution() {
       service.createStudent(2);
    }

    @Bean
    @ConditionalOnProperty(prefix = "autoload", name = "service", havingValue = "load")
    public Executor executorInit(StudentAccountService service) {
        return new Executor(service);
    }
}

