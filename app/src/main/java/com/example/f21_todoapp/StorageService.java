package com.example.f21_todoapp;

import android.app.Activity;
import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StorageService {

String filename = "tasks.txt";


    public void saveTask(Activity context, ToDo task){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND);// open file and continue writing
            // I have to write byte array only
            // I have to convert task to string then to byte array
            fileOutputStream.write((task.toString()+ "$").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// print all previous error
        }
        finally {
            // this will run if we have exception or not
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //file outputstream for writing to the file
    }

    public void resetAllTask(Activity context){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);// earas data
            fileOutputStream.write("".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// print all previous error
        }
        finally {
            // this will run if we have exception or not
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //file outputstream for writing to the file
    }

    public ArrayList<ToDo> getAllTasks(Activity activity){
        FileInputStream fileInputStream = null;
        ArrayList<ToDo> list = new ArrayList<>(0);
        StringBuffer stringBuffer = new StringBuffer();
        int read = 0;
        try {

            // shopping - Nov 25, 2021$Reading - Nov 26, 2021$Studing - Nov 30, 2021
            fileInputStream = activity.openFileInput(filename);
            while ( (read = fileInputStream.read()) != -1){//
                stringBuffer.append((char)read);
            }
            // write a function to conver this string buffer into list of tasks
           list =  fromStringToListOfTODo(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return list;
    }

    //shopping - Nov 25, 2021$Reading - Nov 26, 2021$Studing - Nov 30, 2021
    private ArrayList<ToDo> fromStringToListOfTODo(String stringFromTheFile){

        ArrayList<ToDo> list = new ArrayList<>(0);
        int index = 0;
        for (int i = 0 ; i < stringFromTheFile.toCharArray().length ; i++){
            if (stringFromTheFile.toCharArray()[i] == '$'){
                String fullTask = stringFromTheFile.substring(index, i - 1 );
                list.add(ToDo.fromString(fullTask));
                index = i + 1;
            }
        }

        return list;

    }




    // file inputstream for reading from the file
}
