package com.stenden.testing.service;

import com.stenden.testing.model.Todo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ron on 14/12/2016.
 */
@Component
public class MemoryTodoServiceImpl implements TodoService {

    private List<Todo> data =  new ArrayList<Todo>();
    private static volatile int currentId = 0;

    @PostConstruct
    public void init() {
        this.data.add(new Todo(++currentId, "Hard studeren"));
        this.data.add(new Todo(++currentId, "Cadeau voor de leraar kopen"));
        this.data.add(new Todo(++currentId, "Kerstboom versieren"));
    }


    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<Todo>(this.data.size());
        for (Todo todo : this.data) {
            todos.add(new Todo(todo.getId(), todo.getMessage(), todo.getCompleted()));
        }
        return todos;
    }

    public Todo findById(long id) {
        for (Todo todo : this.data) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void insert(Todo todo) {
        todo.setId(++MemoryTodoServiceImpl.currentId);
        this.data.add(todo);

    }

    public void update(long id, String message, boolean completed) {
        for (Todo todo : this.data) {
            if (todo.getId() == id) {
                todo.setMessage(message);
                todo.setCompleted(completed);
                break;
            }
        }
    }

    public void delete(long id) {
        int index = -1;
        for (int i=0; i < this.data.size(); i++) {
            if (this.data.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            this.data.remove(index);
        }
    }
}
