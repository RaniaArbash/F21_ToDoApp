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
