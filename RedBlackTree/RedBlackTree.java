package com.javarush.task.task36.task3604;

/*
Узел либо красный, либо чёрный.
Корень — чёрный. (В других определениях это правило иногда опускается. Это правило слабо влияет на анализ, так как корень всегда может быть изменен с красного на чёрный, но не обязательно наоборот).
Все листья (NIL) — чёрные.
Оба потомка каждого красного узла — чёрные.
Всякий простой путь от данного узла до любого листового узла, являющегося его потомком, содержит одинаковое число чёрных узлов.
*/
public class RedBlackTree {
    private static final Node EMPTY = new Node(0);// root

    static {// определение веток от корня
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }
    /*инициализация текущего листа, родителя, прародителя, головы*/
    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);// определение головы
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return header.right == EMPTY;
    }// если левая ветка пустая

    public void clear() {
        header.right = EMPTY;
    }// очистка правой ветки

    public void insert(int item) {// добавление нового значения
        current = grand = parent = header;
        EMPTY.element = item;
        while (current.element != item) {
            /*меняем ссылки*/
            great = grand;
            grand = parent;
            parent = current;
            /*если элемент больше текущего , то добавляем в правую ветку, иначе в левую*/
            current = item < current.element ? current.left : current.right;
            /*если цвет левой ветки красный и цвет правой ветки красный*/
            if (current.left.color == Color.RED && current.right.color == Color.RED) {
                reorient(item);
            }
        }

        if (current != EMPTY) {
            return;
        }

        current = new Node(item, EMPTY, EMPTY);

        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item);
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {// перераспределение веток
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {// обмен значениями с возвратом левой ноды
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) {//обмен значениями с возвратом правой ноды
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {// набор цветов
        BLACK,
        RED
    }

    public static class Node {// класс для объекта ветки
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}
