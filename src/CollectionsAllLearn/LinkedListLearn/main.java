package CollectionsAllLearn.LinkedListLearn;
// реализует интерфейсы List, Dequeue, Queue

import java.util.*;

/*
Существует две основные разновидности List:

Базовый контейнер ArrayList, оптимизированный для произвольного доступа к элементам,
но с относительно медленными операциями вставки/удаления элементов в середине списка.

Контейнер LinkedList, оптимизированный для последовательного доступа,
с быстрыми операциями вставки/удаления в середине списка.
Произвольный доступ к элементам LinkedList выполняется относительно медленно,
но по широте возможностей превосходит ArrayList.
 */

public class main {
    public static void main(String[] agrs) {
        List<String> linkedList = new LinkedList<>();
        //Для добавления элемента в конец списка используется метод add(), для удаления используется метод remove().
        linkedList.add("Barsik"); // добавляет новый элемент в конец списка
        linkedList.add("Murzik"); // Метод add() итератора вводит новый элемент до текущей позиции итератора
        linkedList.add("Ryzhik");

        // Чтобы иметь возможность вставлять в середину, используйте интерфейс ListIterator.
        Iterator<String> iterator = linkedList.iterator();

        /* Интерфейс ListIterator расширяет интерфейс Iterator и определяет ряд дополнительных методов:

        void add(E obj): вставляет объект obj перед элементом, который должен быть возвращен следующим вызовом next()
        boolean hasNext(): возвращает true, если в коллекции имеется следующий элемент, иначе возвращает false
        boolean hasPrevious(): возвращает true, если в коллекции имеется предыдущий элемент, иначе возвращает false
        E next(): возвращает текущий элемент и переходит к следующему, если такого нет, то генерируется исключение NoSuchElementException
        E previous(): возвращает текущий элемент и переходит к предыдущему, если такого нет, то генерируется исключение NoSuchElementException
        int nextIndex(): возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
        int previousIndex(): возвращает индекс предыдущего элемента. Если такого нет, то возвращается число -1
        void remove(): удаляет текущий элемент из списка. Таким образом, этот метод должен быть вызван после методов next() или previous(), иначе будет сгенерировано исключение IlligalStateException
        void set(E obj): присваивает текущему элементу, выбранному вызовом методов next() или previous(), ссылку на объект obj
         */

        String firstCat = iterator.next();
        System.out.println("обратиться к первому элементу: " + firstCat);
        String secondCat = iterator.next();
        System.out.println("обратиться ко второму элементу: " + secondCat);

        linkedList.add("Keksik");
        linkedList.add("Puzik");
        linkedList.add("Endik");
        System.out.println(linkedList.toString());

        ListIterator<String> iterator2 = linkedList.listIterator();
        iterator2.next(); // пропускаем первый элемент списка
        iterator2.add("SecondElement");
        System.out.println(linkedList.toString());

        // Создаём LinkedList
        LinkedList ll = new LinkedList();

        // Добавляем элементы в LinkedList
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("Изначальное содержание ll: " + ll);

        // Удаляем элементы из LinkedList
        ll.remove("F");
        ll.remove(2);
        System.out.println("Содержание ll после удаления: " + ll);

        // Удаляем первый и последний элементы
        ll.removeFirst();
        ll.removeLast();
        System.out.println("ll после удаления первого и последнего: " + ll);

        // Получаем и устанавливаем значение
        Object val = ll.get(2);
        ll.set(2, (String) val + " Изменено");
        System.out.println("ll после изменения: " + ll);

    }
}
