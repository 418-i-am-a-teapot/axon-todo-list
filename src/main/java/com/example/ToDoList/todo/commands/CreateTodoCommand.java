package com.example.ToDoList.todo.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class CreateTodoCommand {

    @TargetAggregateIdentifier
    private final UUID id;
    private final String todoItem;
}
