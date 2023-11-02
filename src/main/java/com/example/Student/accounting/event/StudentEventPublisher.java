package com.example.Student.accounting.event;

import com.example.Student.accounting.entity.Student;
import com.example.Student.accounting.entity.StudentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publishStudentEvent(final Student student) {
        System.out.println("Publishing custom event. ");
        StudentEvent customSpringEvent = new StudentEvent(this, student);
        publisher.publishEvent(customSpringEvent);
    }
}
