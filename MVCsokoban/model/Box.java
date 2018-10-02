package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.view.Field;

import java.awt.*;

/**
 * Created by Admin on 01.10.2018.
 */
public class Box extends CollisionObject implements Movable{
    public Box(int x, int y) {
        super(x, y);
    }

    /*метод должен:
     устанавливать какой-то цвет
      рисовать какие-то примитивные фигуры.
     Проследи, чтобы центр фигуры имел координаты x и y, а высота и ширина соответствовали
        значениям полей height и width.*/
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }
    //должен смещать координаты объектов (x и y) на переданные значения
    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
