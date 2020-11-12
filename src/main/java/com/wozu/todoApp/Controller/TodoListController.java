package com.wozu.todoApp.Controller;

import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Service.TodoListService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {

    Logger logger = LoggerFactory.getLogger(TodoListController.class);

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/get/{title}")
    public Optional<TodoList> getTodoListByTitle(@PathVariable String title) {
        return todoListService.getTodoListByTitle(title);
    }

    @GetMapping("/get/all")
    public Iterable<TodoList> getAllTodoLists(){
        return todoListService.getAllTodoLists();
    }


    @PostMapping("/post")
    public JSONObject postTodoList(@RequestBody TodoList todoList) {
        return todoListService.postTodoList(todoList);
    }

    @PutMapping("/put/{title}")
    public JSONObject putTodoListByTitle(@PathVariable String title, @RequestBody TodoList newTodoList) {
        logger.debug("Request Body", newTodoList);
        System.out.println("My Request Body: "+ newTodoList);
        return todoListService.updateTodoListByTitle(title, newTodoList);
    }

    @DeleteMapping("/delete/{title}")
    public JSONObject deleteTodoListByTitle(@PathVariable String title) {
        return todoListService.deleteTodoListByTitle(title);
    }

    @DeleteMapping("/delete/all")
    public JSONObject deleteAllTodoLists(){
        return todoListService.deleteAllTodoLists();
    }
}
