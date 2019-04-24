package com.example.ToDoList.todo.rest;

import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ToDoList.todo.commands.CreateTodoCommand;
import com.example.ToDoList.todo.service.TodoService;

@Controller
@Path("/todo")
public class TodoController {

    private final CommandGateway commandGateway;
    private final TodoService todoService;

    @Autowired
    public TodoController(CommandGateway commandGateway, TodoService todoService) {
        this.commandGateway = commandGateway;
        this.todoService = todoService;
    }

    @GET
    public Response getToDoList() {

        return Response.ok("Hello TodoList World").build();
    }

    @POST
    @Path("/axon/create")
    public Response createTodo() {
        commandGateway.send(new CreateTodoCommand(UUID.randomUUID(), "Test item"));
        return Response.ok().build();
    }
}
