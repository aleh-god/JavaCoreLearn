package PaternLearn.Java.util.Iterator;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(new PancakeHouseMenu());
        menus.add(new DinerMenu());
        menus.add(new CafeMenu());

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
