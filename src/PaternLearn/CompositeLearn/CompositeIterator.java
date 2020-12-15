package PaternLearn.CompositeLearn;

import java.util.Iterator;
import java.util.Stack;

//CompositeIterator перебирает элементы MenuItem в комбинации, а также следит за тем, чтобы в перебор были включены все дочерние меню (а также их дочерние меню, и т. д.).
public class CompositeIterator implements Iterator {
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    //Здесь передается итератор комбинации верхнего уровня. Мы сохраняем его в стеке.
    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    } //Помещаем объект в стек

    public Object next() {
        if (hasNext()) { //сначала проверяем существование след элемента вызовом hasNext()
            //Если следующий элемент существует, мы извлекаем текущий итератор из стека и получаем следующий элемент.
            Iterator<MenuComponent> iterator = stack.peek(); //Берем верхний объект стэка не доставая его.
            MenuComponent component = iterator.next();

            stack.push(component.createIterator()); //Затем итератор этого компонента заносится в стек.

            return component;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        if (stack.empty()) { //Чтобы проверить наличие следующего компонента, мы проверяем, пуст ли стек.
            return false;
        //Если стек не пуст, читаем из стека верхний итератор и проверяем, есть ли в стеке следующий элемент.
        // Если нет, метод извлекает компонент из стека и рекурсивно вызывает hasNext().
        } else {
            Iterator<MenuComponent> iterator = stack.peek(); //Берем верхний объект стэка не доставая его.
            if (!iterator.hasNext()) {
                stack.pop(); //Достаем верхний объект стека
                return hasNext();
            } else {
                return true; //А если есть, метод возвращает true.
            }
        }
    }

}
