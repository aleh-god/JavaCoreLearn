package PaternLearn.PaternIterator;

//Класс, который обслуживает обычный Array
public class DinerMenu implements Menu {
    //Массив специально ограничен по размеру
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;

    MenuItem[] menuItems;

    public DinerMenu() {
        //Создаем ограниченный массив
        menuItems = new MenuItem[MAX_ITEMS];
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

        //Он также проверяет, не нарушает ли новый объект максимальный размер массива.
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can’t add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    //Метод возвращает интерфейс Iterator. Клиенту не нужно знать ни то, как коллекция menuItems хранится в DinerMenu,
    // ни то, как реализован DinerMenuIterator. Клиент просто использует итератор для перебора элементов.
    @Override
    public IteratorMy createIterator() {
        return new DinerMenuIterator(menuItems);
    }

    // other menu methods here
}
