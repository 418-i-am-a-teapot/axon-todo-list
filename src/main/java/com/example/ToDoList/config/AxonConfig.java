package com.example.ToDoList.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ToDoList.todo.domain.TodoAggregate;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<TodoAggregate> todoAggregateEventSourcingRepository(EventStore eventStore){
        return EventSourcingRepository
                .builder(TodoAggregate.class)
                .eventStore(eventStore)
                .build();
    }
}
