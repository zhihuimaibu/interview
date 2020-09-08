package model;

/**
 * @author wzh
 * @date 2020/1/7 15:42
 * @description 简单工厂模式
 * 1 工厂类
 * 2 抽象产品
 * 3 具体产品
 * 缺点：如果新增一个产品类（三角形。。。），那么工厂类就要修改，影响了开闭原则 工厂类如果是上帝，会累死上帝的
 * 第一次进步：使用反射加路径的方式
 * 第二次进步：使用工厂方法模式
 */
public class SimpleFactory {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Shape circle = ShapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("Rectangle");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("Square");
        square.draw();

        Circle circle1 = (Circle) ShapeFactory2.getShape(Circle.class);
        circle1.draw();

        Rectangle rectangle1 = (Rectangle) ShapeFactory2.getShape(Rectangle.class);
        rectangle1.draw();

        Square square1 = (Square) ShapeFactory2.getShape(Square.class);
        square1.draw();

    }
}

//产品
interface Shape {
    void draw();
}

//具体产品
class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }

    public void draw() {
        System.out.println("Draw Circle");
    }
}

class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }

    public void draw() {
        System.out.println("Draw Rectangle");
    }
}

class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    public void draw() {
        System.out.println("Draw Square");
    }
}

//创建工厂类
class ShapeFactory {
    public static Shape getShape(String type) {
        if (type == "Circle") {
            return new Circle();
        } else if (type == "Rectangle") {
            return new Rectangle();
        } else if (type == "Square") {
            return new Square();
        }
        return null;
    }
}

//简单工厂模式的第一次修改，利用反射机制加全路径的形式
class ShapeFactory2 {
    public static Object getShape(Class<? extends Shape> clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(clazz.getName()).newInstance();
    }
}

