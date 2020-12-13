package PaternLearn.CompositeLearn;

import java.util.Iterator;

//Итератор, который всегда возвращает false при вызове hasNext()
public class NullIterator implements Iterator {

    public Object next() {
        return null;
        }

    public boolean hasNext() {
        return false;
        }

    //NullIterator не поддерживает удаление.
    public void remove() {
        throw new UnsupportedOperationException();
        }
}
