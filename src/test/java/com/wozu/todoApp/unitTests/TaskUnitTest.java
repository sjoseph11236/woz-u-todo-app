package com.wozu.todoApp.unitTests;

import com.wozu.todoApp.Model.Task;
import org.junit.jupiter.api.BeforeEach;

public class TaskUnitTest {
//    Arrange
    Task task;

    @BeforeEach
    public void setUp() {
        task = new Task();
        System.out.println(task);

    }


//    Act
    @Test
    public void test(){}
//    Assert

}
