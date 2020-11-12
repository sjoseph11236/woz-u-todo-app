package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.Task;
import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Repo.TaskRepo;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

   @Override
    public Optional<Task> getTaskById(UUID id) {
        return taskRepo.findById(id);
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTasks() {
        taskRepo.deleteAll();

        JSONObject response =  new JSONObject();
        response.put("message", "deleted all tasks!");
        return response;
    }

    @Override
    public JSONObject deleteTaskById(UUID id) {
        taskRepo.deleteById(id);

        JSONObject response =  new JSONObject();
        response.put("message", "deleted task!");
        return response;
    }

    @Override
    public JSONObject updateTaskById(UUID id, Task newTask) {
        Optional<Task> optionalTodoList = taskRepo.findById(id);
        optionalTodoList.map(task -> {
            task.setDescription(newTask.getDescription());
            task.setIsComplete(newTask.getIsComplete());
            task.setTodoList(newTask.getTodoList());
            return task;
        });

        JSONObject response =  new JSONObject();
        response.put("message", "updated task!");
        return response;
    }

    @Override
    public JSONObject postTask(Task task) {
        taskRepo.save(task);

        JSONObject response =  new JSONObject();
        response.put("message", "posted task!");
        return response;
    }
}
