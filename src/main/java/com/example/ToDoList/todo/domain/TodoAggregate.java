package com.example.ToDoList.todo.domain;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.ToDoList.todo.commands.CreateTodoCommand;
import com.example.ToDoList.todo.events.CreateTodoEvent;
import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class TodoAggregate {

    @AggregateIdentifier
    private UUID id;

    @CommandHandler
    public TodoAggregate(CreateTodoCommand command) {
        AggregateLifecycle.apply(new CreateTodoEvent(command.getId(), command.getTodoItem()));
    }

    @EventSourcingHandler
    public void onCreate(CreateTodoEvent event) {
        this.id = event.getTodoId();
    }
}
