package com.wozu.todoApp.mock;

import com.wozu.todoApp.Model.TodoList;
import com.wozu.todoApp.Service.TodoListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static java.util.Optional.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


/*
 * Main reference: https://medium.com/@igorski/using-mockito-with-junit-5-babff57e04e0
 *
 */

// this annotation allows Mockito to work with JUnit5
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class MockTodoListService {

    // we don't have to do anything extra with JUnit5, just simply invoke the annotation
    @Mock
    TodoListService service;

    TodoList list;

    @BeforeEach
    public void setUp(){
        list = new TodoList("hello");
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
