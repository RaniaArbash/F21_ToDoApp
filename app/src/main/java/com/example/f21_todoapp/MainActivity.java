package com.example.f21_todoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listOftoDo;
    ActivityResultLauncher<Intent> newToDoActivityResultLauncher;
    ArrayList<ToDo> allTodos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allTodos = ((myApp) getApplication()).getManager().getAllTodos();
//        if (savedInstanceState != null)
//            allTodos = savedInstanceState.getParcelableArrayList("allToDos");
//        else
//           allTodos = new ArrayList<>(0);

        setContentView(R.layout.activity_main);
      //  Intent intent = new Intent();
        listOftoDo =  findViewById(R.id.simpleListView);
        TodoAdapter adapter = new TodoAdapter(this,allTodos);
        listOftoDo.setAdapter(adapter);
        listOftoDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        newToDoActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK){
                                Intent data = result.getData();
                                ToDo newTodo = data.getParcelableExtra("newToDo");

                             //   allTodos.add(newTodo);
                                adapter.notifyDataSetChanged();
                            }
                    }
                }
    );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.todo_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.add:{
//                Intent intent = new Intent(this,AddTodoActivity.class);
//                startActivity(intent);
//                 newToDoActivityResultLauncher.launch(intent);

                 AddNewToDoFragment fragment = new AddNewToDoFragment();
                 fragment.show(getSupportFragmentManager().beginTransaction(),"1");

                 break;
             }
             case R.id.recycler_list:{
                 Intent intent = new Intent(this,ToDoList_RecyclerView_Activity.class);
                 startActivity(intent);
             }
         }
         return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("allToDos",allTodos);
    }

    public void add_task(View view) {


        AddNewToDoFragment fragment = new AddNewToDoFragment();
        fragment.show(getSupportFragmentManager().beginTransaction(),"1");

//        Intent intent = new Intent(this,AddTodoActivity.class);
//        //startActivity(intent);
//        newToDoActivityResultLauncher.launch(intent);
    }
}