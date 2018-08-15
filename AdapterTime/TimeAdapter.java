package com.javarush.task.AdapterTime;

/**
 * Created by Admin on 15.08.2018.
 */
/*Адаптер в другую сторону*/
class TimeAdapter implements TotalTime
{
    private Time time;
    public TimeAdapter(Time time)
    {
        this.time = time;
    }

    public int getTotalSeconds()
    {
        return time.getHours()*60*60+time.getMinutes()*60 + time.getSeconds();
    }
}