package PaternLearn.CompositeLearn;

import java.util.Iterator;

//это класс листового узла на диаграмме классов паттерна Компоновщик, и он реализует поведение элементов комбинации
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    //Группу «комбинационных» методов — add remove getChild - пропускаем
    //При попытке вызвать их для MenuItem будет выдано исключение UnsupportedOperationException.

    public String getName() { return name; }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    //Листку-Пункту меню не нужен итератор для погружения. Он возвращает нулевой итератор.
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }

    //Метод вывода - общий метод для листьев и узлов - и разные реализации
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println(" -- " + getDescription());
    }
}
