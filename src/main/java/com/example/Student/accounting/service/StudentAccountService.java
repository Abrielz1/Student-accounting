package com.example.Student.accounting.service;

import com.example.Student.accounting.entity.Student;
import com.example.Student.accounting.exceptions.ObjectNotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
@Component
@ShellComponent
@RequiredArgsConstructor
public class StudentAccountService {

    private Long studentId = 0L;

    private final Map<Long, Student> heapOfStudents = new HashMap<>();

    public Student createStudent(String firstName, String lastname, Byte Age) {
        return new Student(studentId++, firstName, lastname, Age);
    }

    @ShellMethod(key = "c")
    public void createStudent(@ShellOption(value = "a") Integer amount) {
        for (int i = 0; i < amount; i++) {
            addStudent(createStudent((i + "aaaa"), (i + "bbbbb"), (byte) (18 + i)));
        }
    }

    @ShellMethod(key = "a")
    public void addStudent(@ShellOption(value = "s") Student student) {
        log.info("Student with id {} was added", student.getId());
        heapOfStudents.put(student.getId(), student);
    }

    @ShellMethod(key = "t")
    public void printStudentsList() {
        for (Map.Entry<Long, Student> i : heapOfStudents.entrySet()) {
            System.out.println("student id: " + i.getKey());
            System.out.println("Student Firstname" + i.getValue().getFirstName()
                    + "Student Lastname " + i.getValue().getLastName()
                    + "Age is " + i.getValue().getAge());
        }
    }

    @ShellMethod(key = "r")
    public void removeStudent(Long id) {
        if (heapOfStudents.containsKey(id) && !heapOfStudents.isEmpty()) {
            log.info("Student with id {} was removed", id);
            heapOfStudents.remove(id);
        } else {
            log.warn("Student with id {} was not found!", id);
            throw new ObjectNotFoundException("Student was not found!");
        }
    }

    @ShellMethod(key = "p")
    public void purgeHeap() {
        log.info("Faculty was purged!");
        heapOfStudents.clear();
    }
}
