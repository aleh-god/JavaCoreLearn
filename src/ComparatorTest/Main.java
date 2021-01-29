package ComparatorTest;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Person> people = new TreeSet<Person>();
        people.add(new Person("Tom"));
        people.add(new Person("Simone"));
        people.add(new Person("Jack"));
        people.add(new Person("Bob")); //Not added
        people.add(new Person("Kendrick"));
        people.add(new Person("Boob")); //Not added
        people.add(new Person("Aups123456"));

        System.out.printf("TreeSet contains %d elements \n", people.size());
        for(Person peop : people){
            System.out.println(peop.getName());
        }

        //используем класс компаратора для создания объекта TreeSet:
        //Для создания TreeSet здесь используется одна из версий конструктора, которая в качестве параметра принимает компаратор. Теперь вне зависимости от того, реализован ли в классе Person интерфейс Comparable, логика сравнения и сортировки будет использоваться та, которая определена в классе компаратора.
        PersonComparator pcomp = new PersonComparator();
        TreeSet<Person> people2 = new TreeSet<Person>(pcomp);
        people2.add(new Person("Tom"));
        people2.add(new Person("Tam"));
        people2.add(new Person("Nick"));
        people2.add(new Person("Alice"));
        people2.add(new Person("Bill"));
        people2.add(new Person("Tom")); //Not added
        people2.add(new Person("Tim"));
        people2.add(new Person("Simone"));
        people2.add(new Person("Jack"));
        System.out.printf("TreeSet contains %d elements \n", people2.size());
        for(Person  p : people2){
            System.out.println(p.getName());
        }

        //мы можем применять сразу несколько компараторов по принципу приоритета.
        //Интерфейс компаратора определяет специальный метод по умолчанию thenComparing, который позволяет использовать цепочки компараторов для сортировки набора:
        Comparator<PersonLong> pcompLong = new PersonNameComparator().thenComparing(new PersonAgeComparator());
        TreeSet<PersonLong> peopleLong = new TreeSet(pcompLong);

        peopleLong.add(new PersonLong("Tom", 23));
        peopleLong.add(new PersonLong("Agata", 14));
        peopleLong.add(new PersonLong("Nick",34));
        peopleLong.add(new PersonLong("Tom",10));
        peopleLong.add(new PersonLong("Bill",14));

        System.out.printf("TreeSet contains %d elements \n", peopleLong.size());
        for(PersonLong  p : peopleLong){
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
