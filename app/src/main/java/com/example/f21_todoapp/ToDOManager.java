package com.example.f21_todoapp;

import java.util.ArrayList;

public class ToDOManager {

    private  ArrayList<ToDo> allTodos = new ArrayList<>(0);

    public ArrayList<ToDo> getAllTodos() {
        return allTodos;
    }

    public void addNewTodo(ToDo newTodo){
        allTodos.add(newTodo);
    }

    // file system
    // Room db
}
