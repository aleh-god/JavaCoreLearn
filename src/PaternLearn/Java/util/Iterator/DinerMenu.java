package PaternLearn.Java.util.Iterator;

import java.util.HashSet;
import java.util.Iterator;

public class DinerMenu implements Menu{

    HashSet<MenuItem> menuItems;

    public DinerMenu() {
        menuItems = new HashSet<MenuItem>();
        addItem("Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad" , false, 3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);
        // a couple of other Diner Menu items added here
    }

    //Метод addItem() получает все параметры, необходимые для создания MenuItem, и создает объект.
    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        //Задаем параметры объекта (сетер) через конструктор.
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    @Override
    public Iterator setIterator() {
        return menuItems.iterator();
    }
}
