package PaternLearn.PaternIterator;

//Теперь поддержку итераторов необходимо интегрировать в реализацию официантки
public class WaitressOld {

    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    MenuItem menuItem;

    //В конструкторе передаются два объекта меню.
    public WaitressOld(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    //Метод printMenu() теперь создает два итератора
    public void printMenu() {
        IteratorMy pancakeIterator = pancakeHouseMenu.createIterator();
        IteratorMy dinerIterator = dinerMenu.createIterator();
        IteratorMy cafeIterator = cafeMenu.createIterator();
        //А затем вызывает перегруженный метод printMenu() для каждого итератора.
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    //Перегруженный метод printMenu() использует Iterator для перебора и вывода элементов меню.
                        // Полиморфизм и композиция позволяют нам использовать все возможные Итераторы
    private void printMenu(IteratorMy iterator) {
        while (iterator.hasNext()) {

            // Ошибка. Требует (MenuItem) - проверил оба итератора, вроде next возвращает MenuItem.
            menuItem = (MenuItem) iterator.next();
            System.out.println();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
    // другие методы
}
