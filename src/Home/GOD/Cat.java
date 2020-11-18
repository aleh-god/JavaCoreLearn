package Home.GOD;

public class Cat extends Animal {
    @Override
    String sleep() {
        return "Коты постоянно спят!";
    }
}

class CatSimple {
    int age;
    int birthday;

    // Инициализируем переменные явно
    CatSimple(int i, int j) {
        age = i;
        birthday = j;
    }

    // Инициализируем переменные одним и тем значением
    CatSimple(int i) {
        age = i;
        birthday = i;
    }

    // Присвоим значения по умолчанию 0
    CatSimple() {
        age = 0;
        birthday = 0;
    }
}

// instanceof - Проверка принадлежности к классу.  Это булев оператор, и выражение foo instanceof Foo истинно, если объект foo принадлежит классу Foo или его наследнику, или реализует интерфейс Foo (или, в общем виде, наследует класс, который реализует интерфейс, который наследует Foo).
class IrishCat extends Cat {
}