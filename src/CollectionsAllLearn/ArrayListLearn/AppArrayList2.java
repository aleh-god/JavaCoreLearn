package CollectionsAllLearn.ArrayListLearn;

import java.util.ArrayList;

public class AppArrayList2 {
    public static void main(String[] args) {

        ArrayList<String> people = new ArrayList<String>();
        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        testArray(people);
        people.add(1, "Bob"); // добавляем элемент по индексу 1
        testArray(people);

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта
        testArray(people);

        // проверяем наличие элемента
        if(people.contains("Tom")){
            System.out.println("ArrayList contains Tom");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Robert");
        // удаление по индексу
        people.remove(0);

        //
        Object[] peopleArray = people.toArray();
        for(Object person : peopleArray){
            System.out.println(person);
        }
    }

    public static void testArray(ArrayList<String> people) {
        System.out.printf("ArrayList has %d elements \n", people.size());
        //И поскольку класс ArrayList реализует интерфейс Iterable, то мы можем пробежаться по списку в цикле аля for-each:
        for (String person : people) {
            System.out.println(person);
        }
    }
}
