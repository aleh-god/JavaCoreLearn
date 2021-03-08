package CollectionsAllLearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CorrectSetterGetterList {

    private ArrayList<String> stringList = new ArrayList<>();

    // ArrayList is a mutable container class, though, so you don't actually need a setter at all: simply have callers call getStringList() and then mutate the ArrayList themselves:
    //         dataObjectNameField.getStringList().add("foo");

    //On the other hand, the more common requirement is to prevent callers from being able to mutate internal data structures, so that your class can actually enforce its invariants on its data. ArrayList is always mutable, so if you need to return an ArrayList but you don't want your private state to be modified, you'll need to copy:

    public ArrayList<String> getMyArrayList() {
        return new ArrayList<String>(stringList);
    }

    //Alternatively, if possible, it's better to widen the return type and then return some other implementation that your class can use to enforce its invariants. For example, if you don't want people to modify your ArrayList using a getter method, you could widen the type from ArrayList<String> to List<String> and use an unmodifiable implementation, for example:

    public List<String> getMyList() {
        return Collections.unmodifiableList(stringList);
    }

    //On the other hand, for the setter, it depends on how you want to handle the values. Normally a setFoo method replaces the contents of foo, which you can of course do:

    public void setMyArrayList(ArrayList<String> stringList) {
        this.stringList = stringList;
    }

    //If you do decide to expose a setter that replaces the value, you probably want to first check it for correctness. Since your class initializes the ArrayList in an instance initializer, most likely you don't expect it will ever be null. So you should throw an exception if it is:

    public void setArrayListChekNull(ArrayList<String> stringList) {
        if (stringList == null) {
            throw new NullPointerException("stringList must not be null");
        }
        this.stringList = stringList;
    }


    //But most likely you want to also widen the type you will accept. For example, you could accept any Collection instead of just an ArrayList:

    public void setMyCollectionList(Collection<String> strings) {
        this.stringList = new ArrayList<>(strings); // Конструктор с преобразованием к ArrayList
    }

    //It may be more useful, however, to instead expose methods to mutate the underlying list in other ways. For example, perhaps you simply want to support adding new items to the list:

    public void addMyCollectionList(String string) {
        this.stringList.add(string);
    }

    public void addAllMyCollectionList(Collection<String> strings) {
        this.stringList.addAll(strings);
    }

    //Java 7 added a new Objects.requireNonNull method for exactly this purpose.
}
