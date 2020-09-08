package model;

/**
 * @author wzh
 * @date 2020/1/7 16:24
 * @description 工厂方法模式：
 * 1 抽象共产
 * 2 具体工厂
 * 3 抽象产品
 * 4 具体产品
 * 具体工厂和具体产品 1：1
 * 不再是所有的产品就一个具体工厂，而是每个具体的产品都有一个具体的工厂
 */
public class FactoryMethod {
    public static void main(String[] args) {
        SquareFactory squareFactory = new SquareFactory();
        squareFactory.getShape().draw();

        CircleFactory circleFactory = new CircleFactory();
        circleFactory.getShape().draw();

        RectangleFactory rectangleFactory = new RectangleFactory();
        rectangleFactory.getShape().draw();
    }
}

interface ShapeFactoryMethod {
    Shape getShape();
}

class SquareFactory implements ShapeFactoryMethod {

    public Shape getShape() {
        return new Square();
    }
}

class CircleFactory implements ShapeFactoryMethod {

    public Shape getShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactoryMethod {

    public Shape getShape() {
        return new Rectangle();
    }
}