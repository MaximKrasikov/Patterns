package com.javarush.task.AdapterTime;

/**
 * Created by Admin on 15.08.2018.
 */
public class Solution {
    public static void main(String[] args){
        TotalTime totalTime = TimeManager.getCurrentTime();
        Time time = new TotalTimeAdapter(totalTime);
        System.out.println(time.getHours()+":"+time.getMinutes()+":"+time.getSeconds());
        /*AdapterReverse*/
        /*
        Time time = new Time();
        TotalTime totalTime = new TimeAdapter(time);
        System.out.println(time.getTotalSeconds());
        */
    }
}
