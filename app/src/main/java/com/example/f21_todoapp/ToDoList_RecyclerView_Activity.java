package com.example.f21_todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList_RecyclerView_Activity extends AppCompatActivity implements ToDoList_RecyclerAdapter.ToDoClickListener {
RecyclerView list_of_todo;
TextView nodata_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_recycler_view);
        nodata_text = findViewById(R.id.nodata_text);
        list_of_todo = findViewById(R.id.todo_list_recycler);
        ArrayList<ToDo> allItems = ( (myApp)getApplication()).getManager().getAllTodos();
        if (allItems.size() == 0){
            nodata_text.setVisibility(View.VISIBLE);
            nodata_text.setText("No Tasks!!!");

        }
        else {
            nodata_text.setVisibility(View.INVISIBLE);
            ToDoList_RecyclerAdapter adapter = new ToDoList_RecyclerAdapter(this, allItems);
            adapter.listener = this;
            list_of_todo.setLayoutManager(new LinearLayoutManager(this));

            list_of_todo.setAdapter(adapter);
        }
    }

    @Override
    public void onToDoSelected(ToDo selectedToDo) {
        Toast.makeText(this, "The selected task is " + selectedToDo.task,Toast.LENGTH_LONG).show();
    }
}