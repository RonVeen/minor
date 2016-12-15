package com.stending.testing.controller;

import com.stenden.testing.configuration.TestContext;
import com.stenden.testing.configuration.WebContext;
import com.stenden.testing.model.Todo;
import com.stenden.testing.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Ron on 15/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebContext.class})
@WebAppConfiguration
public class TodoControllerTest {

    private MockMvc mockMvc;

    @Autowired private TodoService todoServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(todoServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void findAll_ShouldReturnAllExistingTodos() throws Exception {
        Todo todo1 = new Todo(1, "First Todo");
        Todo todo2 = new Todo(2, "Second Todo");
        Todo todo3 = new Todo(3, "Third Todo", true);

        when(todoServiceMock.findAll()).thenReturn(Arrays.asList(todo1, todo2, todo3));

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$..*", hasSize(9)))
                .andExpect(jsonPath("$[0].message", is("First Todo")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].completed", is(true)));
    }
}
