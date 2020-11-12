package com.wozu.todoApp;

import com.wozu.todoApp.Model.Task;
import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Repo.TaskRepo;
import com.wozu.todoApp.Repo.TodoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
     TodoListRepo todoListRepo;

    @Override
    public void run(String... args) throws Exception {
//        seed();
        if(taskRepo.count() == 0 && todoListRepo.count() == 0) {
            TodoList newTodoList = new TodoList("Chores");

            todoListRepo.save(newTodoList);

            Optional<TodoList> optionalTodoList = todoListRepo.findTodoListByTitle(newTodoList.getTitle());

            Task newTask = new Task(optionalTodoList.get(), "Clean Room");

            taskRepo.save(newTask);
            System.out.println("Database seeded");
        }
    }

//    public static void seed() {
//
//
//    }

}
