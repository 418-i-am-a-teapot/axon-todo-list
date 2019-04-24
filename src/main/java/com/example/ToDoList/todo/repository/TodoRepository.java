package com.example.ToDoList.todo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList, UUID> {
}
