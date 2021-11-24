package com.example.f21_todoapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ToDo implements Parcelable {
    String task;
    String date;

    public ToDo(String task, String date) {
        this.task = task;
        this.date = date;
    }

    protected ToDo(Parcel in) {
        task = in.readString();
        date = in.readString();
    }


    // Shopping _ Nov - 25 - 2021
    @Override
    public String toString() {
        return task +" _ " + date;
    }

    public static ToDo fromString(String stringTask){
        ToDo todo = new ToDo("","");
        for (int i = 0; i<stringTask.toCharArray().length; i++){
            if (stringTask.toCharArray()[i] == '_'){
                String task = stringTask.substring(0, i - 1  );
                String date = stringTask.substring(i + 1,stringTask.toCharArray().length );
                todo = new ToDo(task,date);
            }
        }
        return todo;
    }

    public static final Creator<ToDo> CREATOR = new Creator<ToDo>() {
        @Override
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        @Override
        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(task);
        parcel.writeString(date);
    }
}
