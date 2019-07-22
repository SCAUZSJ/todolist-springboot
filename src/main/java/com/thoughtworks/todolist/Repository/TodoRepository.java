package com.thoughtworks.todolist.Repository;

import com.thoughtworks.todolist.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, String> {
}
