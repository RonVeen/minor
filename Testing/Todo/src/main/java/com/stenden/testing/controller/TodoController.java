package com.stenden.testing.controller;

import com.stenden.testing.service.TodoService;
import com.stenden.testing.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ron on 14/12/2016.
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping(value = "/api/todo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = service.findAll();
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }

}
