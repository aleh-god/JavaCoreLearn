package Java.Animal;

import java.util.Objects;

public class Cat extends Animal {
    String name;
    String color;
    enum Poroda { // Специальный тип, колекция констант. Когда переменная может принимать ограниченные значения
        SIBIR,
        IRLAND,
        SFINX
    } // Присвоение -> Poroda Iriska = Poroda.IRLAND;

    // Определяем абстрактый метод
    public void makeSound() {
        System.out.println("Meaw");
    }

    // Сравнение созданных объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        Cat cat = (Cat) o;
        return name.equals(cat.name) &&
                color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}
