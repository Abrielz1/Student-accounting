package com.example.Student.accounting.entity;

import org.springframework.context.ApplicationEvent;

public class StudentEvent extends ApplicationEvent {

    private Student student;

    public StudentEvent(Object source, Student student) {
        super(source);
        this.student = student;
    }

    public Student getMessage() {
        return student;
    }
}
