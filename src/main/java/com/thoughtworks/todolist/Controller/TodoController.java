package com.thoughtworks.todolist.Controller;

import com.thoughtworks.todolist.Entity.Todo;
import com.thoughtworks.todolist.Respone.ResponseDIY;
import com.thoughtworks.todolist.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;


    @PostMapping(produces = {"application/json"})
    public ResponseDIY add(@RequestBody Todo todo) throws RuntimeException{
        Todo todo1 = todoService.add(todo);
        return new ResponseDIY(HttpStatus.CREATED.value(),todo1);
    }
    @PutMapping("/{id}")
    public ResponseDIY updateById(@PathVariable String id, @RequestBody Todo todo){
        return new ResponseDIY(HttpStatus.OK.value(),todoService.update(id,todo));
    }
    @GetMapping()
    public ResponseDIY findAll(){
        return new ResponseDIY(HttpStatus.OK.value(),todoService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseDIY delete(@PathVariable String id){
        todoService.deleteById(id);
        return new ResponseDIY(HttpStatus.OK.value());
    }
}
