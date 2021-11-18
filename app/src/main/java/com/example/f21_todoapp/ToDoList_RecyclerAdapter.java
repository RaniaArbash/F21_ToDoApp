package com.example.f21_todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoList_RecyclerAdapter extends RecyclerView.Adapter<ToDoList_RecyclerAdapter.TodoViewHolder> {
    Context a_context;
    ArrayList<ToDo> list;

    public interface ToDoClickListener{
        public void onToDoSelected(ToDo selectedToDo);
    }

    ToDoList_RecyclerAdapter(Context context, ArrayList<ToDo> listOfToDos){
        a_context = context;
        list = listOfToDos;
    }

    public ToDoClickListener listener;

    public static class TodoViewHolder extends RecyclerView.ViewHolder{

        private final TextView task_text;
        private final TextView task_date;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            task_text = itemView.findViewById(R.id.task);
            task_date = itemView.findViewById(R.id.task_date);
        }

        public TextView getTask_text() {
            return task_text;
        }

        public TextView getTask_date() {
            return task_date;
        }

    }


    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(a_context).inflate(R.layout.list_row_item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
            holder.getTask_text().setText(list.get(position).task);
            holder.getTask_date().setText(list.get(position).date);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onToDoSelected(list.get(holder.getAdapterPosition()));
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
