package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Admin on 01.10.2018.
 */
/*может сталкиваться, но не может двигаться*/
public class Wall extends CollisionObject{
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;


        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }
}
