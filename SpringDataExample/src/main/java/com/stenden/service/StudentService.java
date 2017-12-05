package com.stenden.service;

import com.stenden.model.Student;
import com.stenden.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by veenr on 5-12-2017.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Transactional
    public List<Student> findAll() {
        Iterable<Student> it = studentRepository.findAll();
        final List<Student> students = new ArrayList<>();
        //  Java8 StreamSupport.stream(it.spliterator(), false).forEach(s -> students.add(s));
        Iterator<Student> iterator = it.iterator();
        while (iterator.hasNext()) {
            students.add(iterator.next());
        }

        return students;
    }


    @Transactional
    public List<Student> findByLastname(String lastname) {
        return studentRepository.findByLastname(lastname);
    }


    @Transactional
    public void add(Student student) {
        studentRepository.save(student);
    }


    @Transactional
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void remove(Long studentId) {
        studentRepository.delete(studentId);
    }
}
