package com.example.ToDoList.todo.events;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateTodoEvent {

    private final UUID todoId;
    private final String todoItem;
}
