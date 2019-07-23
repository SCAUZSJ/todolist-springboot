package com.thoughtworks.todolist.Repository;

import com.thoughtworks.todolist.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {
    List<Todo> findByOrderByCreateTime();
    Todo findByText(String text);
}
