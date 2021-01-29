package ComparatorTest;
//Однако перед нами может возникнуть проблема, что если разработчик не реализовал в своем классе, который мы хотим использовать, интерфейс Comparable, либо реализовал, но нас не устраивает его функциональность, и мы хотим ее переопределить? На этот случай есть еще более гибкий способ, предполагающий применение интерфейса Comparator<E>.
import java.util.Comparator;

class PersonComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        return a.getName().compareTo(b.getName());
    }
}
