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

    private Long studentId = 1L;

    private final Map<Long, Student> heapOfStudents = new HashMap<>();

    @ShellMethod(key = "enlist")
    public void enlist(String firstName,
                       String lastName,
                       Byte age) {
        addStudent(create(studentId++, firstName, lastName, age));
    }

    @ShellMethod(key = "create")
    public void createStudent(@ShellOption(value = "a") Integer amount) {
        for (int i = 0; i < amount; i++) {
            addStudent(create(studentId++,(i + "aaaa"), (i + "bbbbb"), (byte) (18 + i)));
        }
    }

    private Student create(Long id, String firstName, String lastname, Byte age) {
        return new Student(id, firstName, lastname, age);
    }

    private void addStudent(Student student) {
        log.info("Student with id {} was added", student.getId());
        heapOfStudents.put(student.getId(), student);
    }

    @ShellMethod(key = "print")
    public void printStudentsList() {
        for (Map.Entry<Long, Student> i : heapOfStudents.entrySet()) {
            System.out.println("student id: " + i.getKey());
            System.out.println("Student Firstname" + i.getValue().getFirstName()
                    + " Student Lastname " + i.getValue().getLastName()
                    + " Age is " + i.getValue().getAge());
        }
    }

    @ShellMethod(key = "rem")
    public void removeStudent(Long id) {
        if (heapOfStudents.containsKey(id) && !heapOfStudents.isEmpty()) {
            log.info("Student with id {} was removed", id);
            heapOfStudents.remove(id);
        } else {
            log.warn("Student with id {} was not found!", id);
            throw new ObjectNotFoundException("Student was not found!");
        }
    }

    @ShellMethod(key = "purge")
    public void purgeHeap() {
        log.info("Faculty was purged!");
        heapOfStudents.clear();
    }
}
