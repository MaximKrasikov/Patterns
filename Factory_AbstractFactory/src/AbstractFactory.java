package com.javarush.task.task37.task3702;

public interface AbstractFactory { //наши фабрики Male & Femail реализуют этот интерфейс- фабрика фабрик
    public Human getPerson(int age);

}
