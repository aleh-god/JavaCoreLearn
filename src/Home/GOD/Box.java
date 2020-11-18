package Home.GOD;

public class Box {
    int width; // ширина коробки
    int height; // высота коробки
    int depth; // глубина коробки

    // Конструктор
    Box() {
        width = 10;
        height = 10;
        depth = 10;
    }
    // Второй конструктор
    Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }
    // Третий конструктор для куба
    Box(int len) {
        width = height = depth = len;
    }
    // Коструктор с параметром типа Box
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // вычисляем объём коробки
    int getVolume() {
        return width * height * depth;
    }
}

// Наследование класса
class HeavyBox extends Box {
    int weight; // вес коробки

    // конструктор
    HeavyBox(int w, int h, int d, int m) {
        width = w;
        height = h;
        depth = d;
        weight = m; // масса
    }
}

class ColorBox extends Box {
    String color; // цвет коробки

    // конструктор
    // инициализируем переменные с помощью ключевого слова super
    ColorBox(int w, int h, int d, String m) {
        super(w, h, d); // вызов конструктора суперкласса. Вызов метода super() всегда должен быть первым оператором, выполняемым внутри конструктора подкласса.
        color = m; // цвет
    }
}