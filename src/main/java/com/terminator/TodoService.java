package com.terminator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TodoService {
    List<Todo> todos = Stream.of(new Todo(1, "Task one", "some details", true), 
                                    new Todo(2, "task two", "some other details", false)).collect(Collectors.toList());

    public List<Todo> findAll(){
        return this.todos;
    }

    public Todo addTodo(TodoDto todoDto){
        Todo todo = Todo.builder().id(this.todos.size() + 1).title(todoDto.getTitle()).detail(todoDto.getDetail()).done(todoDto.isDone()).build();
        this.todos.add(todo);

        return todo;
    }

    public Todo findById(Long id){
        Optional<Todo> matchingTodo = this.todos.stream().filter(t -> t.getId() == id).findFirst();

        if(matchingTodo.isEmpty()) throw new NullPointerException("Todo not found");

        Todo todo = matchingTodo.get();

        return todo;
    }

    public Todo updateTodo(Long id, TodoDto todoDto){
        Optional<Todo> matchingTodo = this.todos.stream().filter(t -> t.getId() == id).findFirst();

        if(matchingTodo.isEmpty()) throw new NullPointerException("Todo not found");

        Todo todo = matchingTodo.get();
        todo.setTitle(todoDto.getTitle());
        todo.setDetail(todoDto.getDetail());
        todo.setDone(todoDto.isDone());

        return todo;
    }

    public void deleteTodo(Long id) {
        this.todos.removeIf(t -> t.getId() == id);
    }
}
