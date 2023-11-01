package com.example.Student.accounting.config;

import com.example.Student.accounting.service.Executor;
import com.example.Student.accounting.service.StudentAccountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExeConfigurator {

    @Bean(name = "executor")
    @ConditionalOnProperty(prefix = "autoload", name = "service", havingValue = "load")
    public Executor executorInit(StudentAccountService service) {
        return new Executor(service);
    }
}
