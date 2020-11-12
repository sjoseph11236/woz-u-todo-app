package com.wozu.todoApp.Controller;

import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Service.TodoListService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/get/{title}")
    public Optional<TodoList> getTodoListByTitle(@PathVariable String title){
        return todoListService.getTodoListByTitle(title);
    }

    @GetMapping("/get/all")
    public Iterable<TodoList> getAllTodoLists(){
        return todoListService.getAllTodoLists();
    }


    @PostMapping("/post")
    public JSONObject postTodoList(@RequestBody TodoList todoList){
        return todoListService.postTodoList(todoList);
    }

    @PutMapping("/put/{title}")

    @DeleteMapping("/delete/{title}")

    @DeleteMapping("/delete/all")


}
