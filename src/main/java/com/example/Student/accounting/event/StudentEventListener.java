package com.example.Student.accounting.event;

import com.example.Student.accounting.entity.StudentEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener implements ApplicationListener<StudentEvent> {

    @Override
    public void onApplicationEvent(StudentEvent event) {
        System.out.println("Received student event - " + event.getMessage());
    }
}
