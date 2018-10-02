package com.javarush.task.task34.task3410.model;

/**
 * Created by Admin on 01.10.2018.
 */
/*столкновение объектов*/
    /*дом прозрачный, остальные объекты нет*/
public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    /*метод должен возвращаться true,
    если при перемещении текущего объекта в направлении direction на FIELD_CELL_SIZE произойдет столкновение с объектом gameObject,
     переданным в качестве параметра.
Иначе - возвращать false. Столкновением считать совпадение координат x и y*/
    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        boolean result = false;

        switch (direction)
        {

            case LEFT:
                if (getX() - Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case RIGHT:
                if (getX() + Model.FIELD_CELL_SIZE == gameObject.getX() && getY() == gameObject.getY())
                    result = true;
                break;
            case UP:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_CELL_SIZE == gameObject.getY())
                    result = true;
                break;
            case DOWN:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_CELL_SIZE == gameObject.getY())
                    result = true;
                break;
        }
        return result;
    }
}
