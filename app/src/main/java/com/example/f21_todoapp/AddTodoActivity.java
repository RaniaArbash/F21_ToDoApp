package com.example.f21_todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddTodoActivity extends AppCompatActivity {

    EditText task_text;
    DatePicker task_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
        task_text = findViewById(R.id.task_text);
        task_date = findViewById(R.id.datapicker);

    }

    public void save_task(View view) {
        if (!task_text.getText().toString().isEmpty()){
            String task = task_text.getText().toString();
            int month =  task_date.getMonth() + 1;
            String date = task_date.getYear() +"-"+ month +"-" + task_date.getDayOfMonth();
            ToDo newTodo = new ToDo(task,date);

            ((myApp)getApplication()).getManager().addNewTodo(newTodo);

            Intent returnIntent = new Intent();
            returnIntent.putExtra("newToDo",newTodo);

            setResult(Activity.RESULT_OK,returnIntent);
            finish();

        }
    }
}