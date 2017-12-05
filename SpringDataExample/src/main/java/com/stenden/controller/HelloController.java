package com.stenden.controller;



import com.stenden.model.Student;
import com.stenden.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ron on 24/11/2016.
 */


@RestController
@RequestMapping(value = "/rest")
public class HelloController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String Hello() {
        return "hello Stenden";
    }



    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity getAllStudents() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity(students, HttpStatus.OK);
    }


    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.add(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
