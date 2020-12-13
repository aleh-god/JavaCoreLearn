package PaternLearn.CompositeLearn;

public class Main {
    public static void main(String args[]) {

        System.out.println("Паттерн Компоновщик\n");

        //Сначала создаем все объекты меню.
        MenuComponent pancakeHouseMenu =
                new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu =
                new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu =
                new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu =
                new Menu("DESSERT MENU", "Dessert of course!");

        //Также нам понадобится меню верхнего уровня — назовем его allMenus.
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        pancakeHouseMenu.add(new MenuItem(
                "K&B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99));
        pancakeHouseMenu.add(new MenuItem(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99));
        pancakeHouseMenu.add(new MenuItem(
                "Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59));

        allMenus.add(dinerMenu);
        dinerMenu.add(new MenuItem(
                "Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat", true, 2.99
        ));
        dinerMenu.add(new MenuItem(
                "Soup of the day",
                "Soup of the day, with a side of potato salad" , false, 3.29
        ));
        dinerMenu.add(new MenuItem(
                "Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05
        ));
        //В меню также включается другое меню. Для dinerMenu важно только то, что все хранящиеся в нем объекты являются MenuComponent.
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));

        allMenus.add(cafeMenu);
        cafeMenu.add(new MenuItem(
                "Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29
        ));
        cafeMenu.add(new MenuItem(
                "Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69
        ));
        cafeMenu.add(new MenuItem(
                "Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29
        ));

        // добавление других элементов
        // добавление других элементов

        //Сконструированная иерархия меню передается классу Waitress.
        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();
        System.out.println("Печатаем веганское меню\n");
        waitress.printVegetarianMenu();
    }
}
