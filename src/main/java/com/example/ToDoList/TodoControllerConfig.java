package com.example.ToDoList;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.ToDoList.todo.rest.TodoController;

@Configuration
@ApplicationPath("/rest")
public class TodoControllerConfig extends ResourceConfig {

    public TodoControllerConfig() {
        register(TodoController.class);
    }
}
