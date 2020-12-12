package PaternLearn.PaternIterator;

import java.util.ArrayList;

//Класс, который обслуживает ArrayList<MenuItem>
public class PancakeHouseMenu implements Menu {

    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();

        addItem("K&B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }
    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        //Задаем параметры объекта (сетер) через конструктор.
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }


    //Метод возвращает интерфейс Iterator. Клиенту не нужно знать ни то, как коллекция menuItems хранится в DinerMenu,
    // ни то, как реализован DinerMenuIterator. Клиент просто использует итератор для перебора элементов.
    @Override
    public IteratorMy createIterator() {
        return new PancakeHouseIterator(menuItems);
    }

    // другие методы

}
