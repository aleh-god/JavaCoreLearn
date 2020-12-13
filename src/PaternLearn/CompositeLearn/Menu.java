package PaternLearn.CompositeLearn;

import java.util.ArrayList;
import java.util.Iterator;

//класс комбинации может содержать элементы MenuItem или другие Menu.
//Этот класс не реализует пару методов MenuComponent (getPrice() и isVegetarian()), потому что эти методы не имеют особого смысла для Menu.
public class Menu extends MenuComponent {
    //Menu может иметь любое количество потомков типа MenuComponent;
    //для их хранения будет использоваться внутренняя коллекция ArrayList.
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;
    Iterator<MenuComponent> iterator = null;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Методы работы с компонентами
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) { menuComponents.remove(menuComponent); }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    //Методы работы с меню
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Обратите внимание: мы не переопределяем getPrice() или isVegetarian(), потому что эти методы не имеют смысла для Menu.
    //При попытке вызвать их для Menu будет выдано исключение UnsupportedOperationException.

    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }


    //Метод вывода - общий метод для листьев и узлов - и разные реализации
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        //Мы используем итератор для перебора всех компонентов объекта Menu...
        //Ими могут быть другие объекты Menu или объекты MenuItem.
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            //Так как и Menu, и MenuItem реализуют метод print(), мы просто вызываем print(), а все остальное они сделают сами.
            //Рекурсия!
            menuComponent.print();
        }
    }
}
