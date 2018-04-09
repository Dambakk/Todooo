package com.example.dambakk.todooo;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TodoItemModel {

    private String title;
    private String timestampCreated;
    private boolean isDone;

    public TodoItemModel(){

    }

    public TodoItemModel(String title){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.title = title;
        this.timestampCreated = Long.toString(timestamp.getTime());
        this.isDone = false;
    }

    public TodoItemModel(String title, String timestampCreated, boolean isDone){
        this.title = title;
        this.timestampCreated = timestampCreated;
        this.isDone = isDone;
    }


    public String getPrettyDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(Long.parseLong(timestampCreated)));
        return cal.get(Calendar.DATE) + " / " + (cal.get(Calendar.MONTH) + 1) + " / " + cal.get(Calendar.YEAR);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(String timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
