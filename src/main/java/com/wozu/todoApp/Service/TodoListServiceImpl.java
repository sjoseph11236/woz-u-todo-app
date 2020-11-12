package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Repo.TodoListRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TodoListServiceImpl implements TodoListService {

    final TodoListRepo todoListRepo;

    public TodoListServiceImpl(TodoListRepo todoListRepo){
        this.todoListRepo = todoListRepo;
    }

    @Override
    public Optional<TodoList> getTodoListById(UUID id) {
        return todoListRepo.findById(id);
    }

    @Override
    public Optional<TodoList> getTodoListByTitle(String title) {
        return todoListRepo.findTodoListByTitle(title);
    }

    @Override
    public Iterable<TodoList> getAllTodoLists() {
        return todoListRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTodoLists() {
        todoListRepo.deleteAll();

        JSONObject response =  new JSONObject();
        response.put("message", "deleted all todo lists!");
        return response;
    }

    @Override
    public JSONObject deleteTodoListById(UUID id) {
        todoListRepo.deleteById(id);

        JSONObject response =  new JSONObject();
        response.put("message", "deleted todo list!");
        return response;
    }

    @Override
    public JSONObject deleteTodoListByTitle(String title) {
        todoListRepo.deleteTodoListByTitle(title);

        JSONObject response =  new JSONObject();
        response.put("message", "deleted todo list!");
        return response;
    }

    @Override
    public JSONObject updateTodoListById(UUID id, TodoList newTodoList) {
        Optional<TodoList> optionalTodoList = todoListRepo.findById(id);
        optionalTodoList.map(todoList -> {
            todoList.setTitle(newTodoList.getTitle());
            todoList.setTasks(newTodoList.getTasks());
            return todoList;
        });

        JSONObject response =  new JSONObject();
        response.put("message", "updated todo list!");
        return response;
    }

    @Override
    public JSONObject updateTodoListByTitle(String title, TodoList newTodoList) {
        Optional<TodoList> optionalTodoList = todoListRepo.findTodoListByTitle(title);
        optionalTodoList.map(todoList -> {
            todoList.setTitle(newTodoList.getTitle());
            todoList.setTasks(newTodoList.getTasks());
            return todoList;
        });

        JSONObject response =  new JSONObject();
        response.put("message", "updated todo list!");
        return response;
    }

    @Override
    public JSONObject postTodoList(TodoList todoList) {
       todoListRepo.save(todoList);

        JSONObject response =  new JSONObject();
        response.put("message", "posted todo list!");
        return response;
    }
}
