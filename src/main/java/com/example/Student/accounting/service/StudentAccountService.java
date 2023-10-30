package com.example.Student.accounting.service;

import com.example.Student.accounting.entity.Student;
import com.example.Student.accounting.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class StudentAccountService {

    private final Map<Long, Student> heapOfStudents = new HashMap<>();

    public void createStudent(Integer amount) {
        for (int i = 0; i < amount; i++) {
            addStudent(new Student((long) i, (i + "aaaa"), (i + "bbbbb"), (short) (18 + i)));
        }
    }

    public void addStudent(Student student) {
        log.info("Student with id {} was added", student.getId());
        heapOfStudents.put(student.getId(), student);
    }

    public void removeStudent(Long id) {
        if (heapOfStudents.containsKey(id)) {
            log.info("Student with id {} was removed", id);
            heapOfStudents.remove(id);
        } else {
            log.warn("Student with id {} was not found!", id);
            throw new ObjectNotFoundException("Student was not found!");
        }
    }

    public void purgeHeap() {
        log.info("Faculty was purged!");
        heapOfStudents.clear();
    }
}
