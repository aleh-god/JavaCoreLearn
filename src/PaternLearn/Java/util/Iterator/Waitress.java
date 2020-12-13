package PaternLearn.Java.util.Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    //Меню можно поместить в массив. И управлять их перечнем в дальнейшем
    ArrayList<Menu> menus;

    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        Iterator<Menu> menuIterator = menus.iterator();
        while(menuIterator.hasNext()) {
            System.out.println("\n----\nMENU");
            Menu menu = menuIterator.next();
            printMenu(menu.setIterator());
        }
    }

    void printMenu(Iterator<Menu> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
