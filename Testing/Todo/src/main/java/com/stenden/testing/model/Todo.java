package com.stenden.testing.model;

/**
 * Created by Ron on 14/12/2016.
 */
public class Todo {

    private long id;
    private String message;
    private boolean completed;

    public Todo() {
    }

    public Todo(String message) {
        this.message = message;
    }

    public Todo(String message, boolean completed) {
        this.message = message;
        this.completed = completed;
    }

    public Todo(long id, String message, boolean completed) {
        this.id = id;
        this.message = message;
        this.completed = completed;
    }

    public Todo(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", completed=" + completed +
                '}';
    }
}
