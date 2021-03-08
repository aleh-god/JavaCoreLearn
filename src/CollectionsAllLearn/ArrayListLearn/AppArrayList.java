package CollectionsAllLearn.ArrayListLearn;

import java.util.*;

public class AppArrayList {
    public static void main (String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red"); // Добавить элемент в список
        colors.add("Blue");
        colors.add("Green");
        colors.add("Orange");
        colors.remove("Green"); // Удалить элемент из списока

        System.out.println(colors);
        System.out.println("Число элементов списка: " + colors.size()); // Число элементов списка

        if (colors.contains("Blue"))
            System.out.println("В списке есть синий цвет."); // Возвращает верно, если содержит элемент в списке

        for (int i = 0; i < colors.size(); i++) {
            System.out.println(i + " в списке - " + colors.get(i));// Возвращает элемент на указанной позиции
        }

        // colors.clear();
        // Удалаяет все элементы списка

        // Список, который запоминает очередность добавления в коллекцию
        LinkedList<String> chain = new LinkedList<>();
        chain.add("One");
        chain.add("Two");
        chain.add("Three");
        chain.add("One");

        System.out.println(chain);
        System.out.println("Добавлено первым: " + chain.getFirst());

        // HashMap используется для хранения пары ключ+значение
        HashMap<String, Integer> points = new HashMap<>();
        points.put("Any", 150);
        points.put("Ken", 100);
        points.put("Barby", 50);
        System.out.println("Очки Кена: " + points.get("Ken"));

        // Set используется для хранения набора абстракций. Не может содержать дубликаты элементов
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("B"); //Не может содержать дубликаты элементов

        System.out.println(set + " - Количество уникальных значений: " + set.size());

        // LinkedHashSet Совмещает два списка - уникальные значения и очередность добавления.
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        hs.add("Key");
        hs.add("Spot");
        hs.add("Dot");
        hs.add("Spot");

        System.out.println(hs);
        System.out.println("Количество уникальных значений: " + hs.size());

        ArrayList <Integer> num = new ArrayList<>();
        num.add(5);
        num.add(3);
        num.add(10);
        num.add(13);
        num.add(17);
        num.add(8);

        // Управление списком
        Collections.sort(num); // Сортировка
        System.out.println("Сортировка списка: " + num);
        System.out.println("Максимальный элемент списка: " + Collections.max(num));
        System.out.println("Минимальный элемент списка: " + Collections.min(num));
        Collections.reverse(num); // Реверс списка
        System.out.println("Реверс списка: " + num);
        Collections.shuffle(num); // Сортировка
        System.out.println("Перемешивание списка: " + num);

        // Итерратор - это объект, проходящий через коллекцию. Класс коллекции предоставляет методы иттерации.
        Iterator<Integer> it = num.iterator();
        Integer value;
        num.iterator(); // Метод перемещает итерратор в начало списка.
        while (it.hasNext()) { // Возвращает лож, если следующего элемента нет.
            value = it.next(); // Возвращает элемент списка и перемещается к следующему.

            System.out.println("Итерратор: " + value);
        }
        }

}
