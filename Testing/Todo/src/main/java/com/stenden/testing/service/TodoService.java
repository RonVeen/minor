package com.stenden.testing.service;

import com.stenden.testing.model.Todo;

import java.util.List;

/**
 * Created by Ron on 14/12/2016.
 */
public interface TodoService {

    List<Todo> findAll();

    Todo findById(long id);

    void insert(Todo todo);

    void update(long id, String message, boolean completed);

    void delete(long id);

}
