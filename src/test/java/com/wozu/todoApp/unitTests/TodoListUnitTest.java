package com.wozu.todoApp.unitTests;

import com.wozu.todoApp.Model.TodoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoListUnitTest {


//    Arrange
    TodoList todoList;
// for each test setup a new object.
    @BeforeEach
    public void setUp() {
        todoList = new TodoList("Chores");
    }

//    Act
    @Test
    public void testTitle() {
        String expected = "Chores";
        String actual = todoList.getTitle();
        //    Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeTitle() {
        String expected = "Grocery";
//        Act
       todoList.setTitle("Grocery");
       String actual = todoList.getTitle();
       //    Assert
        assertEquals(expected, actual);

    }





}
