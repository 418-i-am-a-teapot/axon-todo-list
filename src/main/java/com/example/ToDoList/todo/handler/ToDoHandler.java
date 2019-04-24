package com.example.ToDoList.todo.handler;

import java.time.ZonedDateTime;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.todo.events.CreateTodoEvent;
import com.example.ToDoList.todo.repository.TodoList;
import com.example.ToDoList.todo.repository.TodoRepository;

@Service
public class ToDoHandler {

    private final TodoRepository todoRepository;

    @Autowired
    public ToDoHandler(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @EventHandler
    public void onCreate(CreateTodoEvent event) {
        System.out.println("Received event: " + event.toString() + " at " + ZonedDateTime.now());
        TodoList todoList = new TodoList();
        todoList.setTask(event.getTodoItem());
        todoRepository.save(todoList);
    }
}
