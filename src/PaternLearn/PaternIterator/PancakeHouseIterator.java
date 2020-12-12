package PaternLearn.PaternIterator;

import java.util.ArrayList;

public class PancakeHouseIterator implements IteratorMy {

    ArrayList<MenuItem> menuItems;
    int index;


    public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
        this.index = 0;
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if ( index >= menuItems.size() || menuItems.get(index) == null )
            return false;
        else return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(index);
        index++;
        return menuItem;
    }
}
