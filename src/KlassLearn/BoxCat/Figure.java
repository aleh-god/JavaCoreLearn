package Home.GOD;

public class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    double area() {
        System.out.println("Площадь фигуры");
        return 0;
    }
}

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // Переопределяем метод
    double area() {
        System.out.println("Площадь прямоугольника");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // переопределяем метод
    double area() {
        System.out.println("Площадь треугольника");
        return dim1 * dim2 / 2;
    }
}
