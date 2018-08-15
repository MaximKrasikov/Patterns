package com.javarush.task.AdapterTime;

/**
 * Created by Admin on 15.08.2018.
 */
public class TimeManager {
    public static TotalTime  getCurrentTime(){
       TotalTime time= new TotalTime() {
           @Override
           public int getTotalSeconds() {
               return 0;
           }
       };
        return time;
    }
}
