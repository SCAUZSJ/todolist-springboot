package com.thoughtworks.todolist.Service;

import com.thoughtworks.todolist.Entity.Todo;
import com.thoughtworks.todolist.Enum.DBErrorMsg;
import com.thoughtworks.todolist.ExceptionHandler.Exceptions.DBException;
import com.thoughtworks.todolist.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final String LOCATION = "["+this.getClass()+"]";
    @Autowired
    private TodoRepository todoRepository;

    public void add(Todo todo) throws RuntimeException{

        try {
            todoRepository.saveAndFlush(todo);

        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(this.LOCATION+ DBErrorMsg.DB_INSERT_ERROR.getMessage());
        }
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public void deleteById(String id) throws RuntimeException{
        try {
            todoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(this.LOCATION+ DBErrorMsg.DB_INSERT_ERROR.getMessage());
        }
    }
    public Todo findById(String id) {
        return todoRepository.findById(id).get();
    }

    public Todo update(String id, Todo todo) throws RuntimeException{
        todo.setId(id);
        Todo todoNew = null;
        try {
            todoNew = todoRepository.saveAndFlush(todo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(this.LOCATION+DBErrorMsg.DB_UPDATE_ERROR.getMessage());
        }
        return todoNew;
    }

}
