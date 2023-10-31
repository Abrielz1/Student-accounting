package com.example.Student.accounting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private Byte age;

    public Student() {
    }

    public Student(String firstName, String lastName, Byte age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(Long id, String firstName, String lastName, Byte age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
