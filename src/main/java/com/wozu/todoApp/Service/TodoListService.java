package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TodoList;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public interface TodoListService {

    // get one by id

    Optional<TodoList> getTodoListById(UUID id);

    // get one by title

    Optional<TodoList> getTodoListByTitle(String title);

    // get all

    Iterable<TodoList> getAllTodoLists();

    // delete all

    JSONObject deleteAllTodoLists();

    // delete by Id

    JSONObject deleteTodoListById(UUID id);

    // update by Id

    JSONObject updateTodoListById(UUID id, TodoList todoList);

    // post

    JSONObject postTodoList(TodoList todoList);

}
