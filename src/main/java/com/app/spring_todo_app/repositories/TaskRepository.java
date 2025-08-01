package com.app.spring_todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.spring_todo_app.entities.Task;

public interface TaskRepository extends  JpaRepository<Task, Long> {
}