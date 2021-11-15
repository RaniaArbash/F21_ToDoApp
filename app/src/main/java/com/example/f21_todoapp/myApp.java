package com.example.f21_todoapp;

import android.app.Application;

import java.util.ArrayList;

public class myApp extends Application {

    public ToDOManager getManager() {
        return manager;
    }

    private ToDOManager manager = new ToDOManager();

}
