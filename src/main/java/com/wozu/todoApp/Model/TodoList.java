package com.wozu.todoApp.Model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="todo_lists")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;

    @OneToMany(mappedBy = "todoList",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public TodoList() {}

    public TodoList(String title){
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }

}
