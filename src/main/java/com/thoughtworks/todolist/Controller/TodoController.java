package com.thoughtworks.todolist.Controller;

import com.thoughtworks.todolist.Entity.Todo;
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
    public ResponseEntity add(@RequestBody Todo todo) throws RuntimeException{
        todoService.add(todo);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable String id, @RequestBody Todo todo){
        return ResponseEntity.ok().body(todoService.update(id,todo));
    }
    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(todoService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        todoService.deleteById(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
