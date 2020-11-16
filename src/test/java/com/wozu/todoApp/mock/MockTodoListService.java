package com.wozu.todoApp.mock;

import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Service.NumService;
import com.wozu.todoApp.Service.TodoListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;


/*
 * Main reference: https://medium.com/@igorski/using-mockito-with-junit-5-babff57e04e0
 *
 */

// this annotation allows Mockito to work with JUnit5
@ExtendWith(MockitoExtension.class)
public class MockTodoListService {

    // we don't have to do anything extra with JUnit5, just simply invoke the annotation
    @Mock
    TodoListService service;

    // dummy service for testing
    @Mock
    NumService numService;

    TodoList list;

    @BeforeEach
    public void setUp(){
        list = new TodoList("hello");
    }

    @Test
    public void whenCallingMethodThenReturnFive(){
//        given(numService.returnFive()).willReturn(5);
        when(numService.returnFive())
                .thenReturn(5);

        assertEquals(numService.returnFive(), 5);
    }

    @Test
    public void whenCallingGetByIdMethodThenReturnId(){
        when(service
                .getTodoListById(list.getId()))
                .thenReturn(ofNullable(list));

        Optional<TodoList> actual = ofNullable(list);
        Optional<TodoList> expected = service.getTodoListById(list.getId());
        assertThat(actual, equalTo(expected));
    }

}
