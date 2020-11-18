package AnyClassLearn;

// абстрактный класс Фигура
abstract class Figure {
    double dim1;
    double dim2;

    // Конструктор
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // абстрактный метод для вычисления площади
    // Фигура - это абстрактное понятие и мы не можем создать универсальный метод для вычисления площади.
    abstract double area();
}

// Клас Треугольник
class Triangle extends Figure {
    // Конструктор
    Triangle(double a, double b) {
        // Ссылка на супер класс
        super(a, b);
    }

    // переопределяем метод
    double area() {
        return dim1 * dim2 / 2;
    }
}
