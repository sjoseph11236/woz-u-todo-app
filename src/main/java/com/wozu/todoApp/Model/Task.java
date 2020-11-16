package com.wozu.todoApp.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "todoList_id")
    private TodoList todoList;
    private String description;
    private Boolean isComplete = false;
//dafualt constructor - empty parameters
    public Task() {}


// constructor - 2 parameters
    public Task(TodoList todoList, String description) {
        this.todoList = todoList;
        this.description = description;
    }

//constructor - 1 parameter
    public Task(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", todoList=" + todoList +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
