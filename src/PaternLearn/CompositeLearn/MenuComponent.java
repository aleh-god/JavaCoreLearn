package PaternLearn.CompositeLearn;

import java.util.Iterator;

//Иногда лучшее, что можно сделать в реализации по умолчанию, — инициировать исключение времени выполнения.
//Так как одни методы имеют смысл только для MenuItem, а другие — только для Menu, реализация по умолчанию инициирует UnsupportedOperationException.
//Это заглушка для вероятных ошибочных вызовов методов: медоты листа для узла, и наоборот.
public abstract class MenuComponent {

    //Группа «комбинационных» методов — то есть методов для добавления, удаления и получения MenuComponent.
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    //Группа «методов операций», используемых MenuItem.
    public String getName() { throw new UnsupportedOperationException(); }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() { throw new UnsupportedOperationException(); }

    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }

    //Метод print() реализуется как в Menu, так и в MenuItem.
    public void print() {
        throw new UnsupportedOperationException();
    }
}
