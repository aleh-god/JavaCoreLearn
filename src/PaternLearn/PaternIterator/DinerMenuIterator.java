package PaternLearn.PaternIterator;

public class DinerMenuIterator implements IteratorMy {

    MenuItem[] menuItems;
    int position;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.position = 0;
        this.menuItems = menuItems;
    }

    //Метод hasNext() возвращает true, если в массиве еще остались элементы для перебора.
    //Так как выделен массив максимального размера, нужно проверить не только достижение границы массива, но и равенство следующего элемента null (признак последнего элемента).
    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    public MenuItem next() {
        MenuItem menuItem = menuItems[position];
        position = position + 1;
        return menuItem;
    }

}