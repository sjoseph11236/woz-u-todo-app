package com.wozu.todoApp.unitTests;

import com.wozu.todoApp.Model.Task;
import com.wozu.todoApp.Model.TodoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TaskUnitTest {
//    Arrange
    Task task;
    TodoList todoList;

    @BeforeEach
    public void setUp() {
        task = new Task();
        todoList = new TodoList();

        System.out.println(task);
    }


//    Act
    @Test
    public void test(){
        assertNull(task.getTodoList());
    }
//    Assert


    @Test
    public void testDescriptionSetter(){
        String expected = "This is my description";
        task.setDescription("This is my description");
        String actual = task.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void testTodoListSetter(){
        TodoList expected = todoList;
        task.setTodoList(todoList);
        TodoList actual = task.getTodoList();
        System.out.println(actual.hashCode());
        assertEquals(expected, actual);
    }


}
