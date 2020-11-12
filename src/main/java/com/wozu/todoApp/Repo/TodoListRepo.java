package com.wozu.todoApp.Repo;

import com.wozu.todoApp.Model.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoListRepo extends CrudRepository<TodoList, UUID> {
}
