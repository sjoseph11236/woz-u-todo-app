package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.Task;
import com.wozu.todoApp.Model.TodoList;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    // get one by id

    Optional<Task> getTaskById(UUID id);

    // get all

    Iterable<Task> getAllTasks();

    // delete all

    JSONObject deleteAllTasks();

    // delete by Id

    JSONObject deleteTaskById(UUID id);

    // update by Id

    JSONObject updateTaskById(UUID id, Task newTask);

    // post

    JSONObject postTask(Task task);
}
