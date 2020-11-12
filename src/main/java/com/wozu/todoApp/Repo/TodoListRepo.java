package com.wozu.todoApp.Repo;

import com.wozu.todoApp.Model.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TodoListRepo extends CrudRepository<TodoList, UUID> {

    Optional<TodoList> findTodoListByTitle(String title);
    void deleteTodoListByTitle(String title);

}
