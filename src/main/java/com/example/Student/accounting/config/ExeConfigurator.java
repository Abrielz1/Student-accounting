package com.example.Student.accounting.config;

import com.example.Student.accounting.service.Executor;
import com.example.Student.accounting.service.StudentAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExeConfigurator {

    @Bean
    public Executor executorInit(StudentAccountService service) {
        return new Executor(service);
    }
}
