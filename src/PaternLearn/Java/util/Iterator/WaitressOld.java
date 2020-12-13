package PaternLearn.Java.util.Iterator;

import java.util.Iterator;

public class WaitressOld {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    MenuItem menuItem;

    //В конструкторе передаются объекты меню.
    public WaitressOld(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.setIterator();
        Iterator dinerIterator = dinerMenu.setIterator();
        Iterator cafeIterator = cafeMenu.setIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\n----\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\n----\nCafe");
        printMenu(cafeIterator);
    }
    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
    // другие методы
}
