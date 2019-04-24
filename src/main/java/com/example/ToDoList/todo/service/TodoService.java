package com.example.ToDoList.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.todo.repository.TodoList;
import com.example.ToDoList.todo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void createTodo(TodoList todoList) {
        todoRepository.saveAndFlush(todoList);
    }
}
