package com.example.f21_todoapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class myApp extends Application {

    public ToDOManager getManager() {
        return manager;
    }
    Activity appContext ;
    public StorageService storageService = new StorageService();
    private ToDOManager manager = new ToDOManager();

}
