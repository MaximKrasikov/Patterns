package com.javarush.task.AdapterTime;

/**
 * Created by Admin on 15.08.2018.
 */
class TotalTimeAdapter implements Time
{
    private TotalTime totalTime;
    public TotalTimeAdapter(TotalTime totalTime)
    {
        this.totalTime = totalTime;
    }

    @Override
    public int getSeconds() {
        return totalTime.getTotalSeconds() % 60; //секунды
    }

    @Override
    public int getMinutes() {
        return totalTime.getTotalSeconds() / 60; //минуты
    }

    @Override
    public int getHours() {
        return totalTime.getTotalSeconds() / (60*60); //часы
    }
}
