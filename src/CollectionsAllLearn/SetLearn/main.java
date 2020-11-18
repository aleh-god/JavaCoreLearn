package CollectionsAllLearn.SetLearn;

import java.util.*;

public class main {
    public static void main(String[] agrs) {
/*
HashSet, TreeSet и LinkedHashSet относятся к семейству Set.
В множествах Set каждый элемент хранится только в одном экземпляре, а разные реализации Set используют разный порядок хранения элементов.

В HashSet порядок элементов определяется по сложному алгоритму. Если порядок хранения для вас важен, используйте контейнер TreeSet,
в котором объекты хранятся отсортированными по возрастанию в порядке сравнения или LinkedHashSet с хранением элементов в порядке добавления.

Множества часто используются для проверки принадлежности, чтобы вы могли легко проверить, принадлежит ли объект заданному множеству,
поэтому на практике обычно выбирается реализация HashSet, оптимизированная для быстрого поиска.
*/
        int count[] = {34,22,10,60,30,22};
        // Второе 22 отсеется
        Set set = new HashSet();
        try {
            for(int i = 0; i < count.length; i++) {
                set.add(count[i]);
            }
            System.out.println(set);
            TreeSet sortedSet = new TreeSet(set);
            // В примере с TreeSet использовался интерфейс SortedSet, который позволяет сортировать элементы множества.
            // По умолчанию сортировка производится привычным способом, но можно изменить это поведение через интерфейс Comparable.
            System.out.println("Отсортированный список:");
            System.out.println(sortedSet);
            System.out.println("Первый элемент набора: "+ (Integer)sortedSet.first());
            System.out.println("Последний элемент набора: "+ (Integer)sortedSet.last());
        }
        catch(Exception e) {}

        HashSet<String> countryHashSet = new HashSet<>();
        countryHashSet.add("Россия");
        countryHashSet.add("Кот-Д'Ивуар"); // любимая страна всех котов
        countryHashSet.add("Франция");
        countryHashSet.add("Гондурас");
        countryHashSet.add("Кот-Д'Ивуар"); // кот попросил добавить ещё раз для надёжности
        System.out.println("\nРазмер HashSet = " + countryHashSet.size());

        // метод iterator(), который позволяет получить всё множество элементов:
        Iterator<String> iteratorHS = countryHashSet.iterator();
        while (iteratorHS.hasNext()) {
            System.out.print(iteratorHS.next() + ", ");
        }

        System.out.println("\nSortedSet");
        SortedSet<String> animalSet = new TreeSet();
        animalSet.add("Antilope");
        animalSet.add("Fox");
        animalSet.add("Goat");
        animalSet.add("Dog");
        animalSet.add("Elephant");
        animalSet.add("Bear");
        animalSet.add("Hippo");
        animalSet.add("Cat");

        Iterator iterator = animalSet.iterator();

        while(iterator.hasNext()){
            // Antilope Bear Cat Dog Elephant Fox Goat Hippo
            System.out.print(iterator.next().toString() + " ");
        }

        System.out.print("\n" + animalSet.subSet("Dog", "Hippo").toString()); // [Dog, Elephant, Fox, Goat]
        System.out.print("\n" + animalSet.tailSet("Dog").toString()); // [Dog, Elephant, Fox, Goat, Hippo]
        System.out.print("\n" + animalSet.headSet("Dog").toString()); // [Antilope, Bear, Cat]
        System.out.print("\n" + animalSet.first()); // Antilope
        System.out.print("\n" + animalSet.last()); // Hippo

    }
}
