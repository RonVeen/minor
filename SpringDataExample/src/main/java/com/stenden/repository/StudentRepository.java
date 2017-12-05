package com.stenden.repository;

import com.stenden.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by veenr on 5-12-2017.
 */
public interface StudentRepository<S> extends CrudRepository<Student, Long> {
    List<Student> findByLastname(String lastname);
}
