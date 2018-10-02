package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Admin on 01.10.2018.
 */
/*класс будет отвечать за места на игровом поле (дома) в которые нужно сдвинуть все ящики*/
public class Home extends GameObject{
    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }
}
