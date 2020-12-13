package PaternLearn.CompositeLearn;

import java.util.Iterator;

public class Waitress {
    //Мы просто передаем компонент меню верхнего уровня — тот, который содержит остальные меню. Мы назвали его allMenus.
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    //А чтобы вывести всю иерархию меню — все меню и все их элементы — достаточно вызвать метод print() для меню верхнего уровня.
    public void printMenu() {
        allMenus.print();
    }


    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n----");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
                //Реализация isVegetarian() для Menu всегда генерирует исключение. Если это произойдет, мы перехватываем исключение и продолжаем перебор
            } catch (UnsupportedOperationException e) {}
        }
    }
}
