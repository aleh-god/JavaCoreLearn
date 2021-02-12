package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DontUseSteamApi {
    private static enum x {
        one,
        two,
        tree
    }
    private static enum y {
        sex,
        nosex
    }

    /**
     * 1. Стрим из коллекции без промежуточных операций обычно не нужен
     * Если у вас промежуточных операций нет, часто можно и нужно обойтись без стрима.
     * Методы класса Collections выполняют многие подобные функции
     * Collections.max(collection)
     * Для объектов collection:
     * collection.forEach()
     * collection.toArray(new String[0])
     * new ArrayList<>(collection)
     *
     */
    public static void main(String[] args) {

        ArrayList<String> phonesList = new ArrayList<String>();
        phonesList.add("iPhone 8");
        phonesList.add("HTC U12");
        phonesList.add("Huawei Nexus 6P");
        phonesList.add("Samsung Galaxy S9");
        phonesList.add("LG G6");
        phonesList.add("Xiaomi MI6");
        phonesList.add("ASUS Zenfone 2");
        phonesList.add("Sony Xperia Z5");
        phonesList.add("Meizu Pro 6");
        phonesList.add("Lenovo S850");

        System.out.println("Избыточно использовать .stream().forEach :");
        phonesList.stream().forEach(s -> System.out.print(s + ", "));

        HashSet<String> phonesSet = new HashSet<String>();
            phonesSet.add("Мама");
            phonesSet.add("Папа");
            phonesSet.add("Сын");
            phonesSet.add("Дочь");
            phonesSet.add("Бабушка");
            phonesSet.add("Дедушка");

        // Хотите что-то сделать для всех элементов коллекции? Замечательно. Но зачем вам стрим? Напишите просто: collection.forEach();
        System.out.println("\nХотите сделать .forEach для всех элементов коллекции? Замечательно:");
        phonesSet.forEach(s -> System.out.print(s + ", "));
        System.out.println("\nХотите сделать .size() для всех элементов коллекции? Замечательно:");
        System.out.println(phonesSet.size());

        System.out.println("\nСобираетесь преобразовать произвольную коллекцию в список?");
        // phonesSet.stream().collect(Collectors.toList())
        ArrayList<String> listToset = new ArrayList<>(phonesSet);
        // Аналогично:
        new TreeSet<>(phonesList);
        new HashSet<>(phonesList);

        // Вместо collection.stream().toArray(String[]::new);
        System.out.println("способ преобразования в массив ничем не лучше старого доброго:");
        String[] test = phonesSet.toArray(new String[0]);
        for (String n : test
             ) {
            System.out.print(n + ", ");
        }

        // stream.filter(condition).findFirst().isPresent() Зачем вам Optional?
        System.out.println("\nВыполняется ли условие для какого-то элемента стрима? Именно для этого есть специальный метод:");
        boolean anyMatch = phonesList.stream().anyMatch(s -> s.length() < 5);
        System.out.println(anyMatch);

        System.out.println("\nЯ считаю, что использовать специальный метод stream.noneMatch(condition) более выразительно:");
        boolean noneMatch = phonesList.stream().noneMatch(s -> s.length() < 5);
        System.out.println(noneMatch);

        System.out.println("Нужен пустой стрим? Для этого есть специальный метод Stream.empty(). ");
        Stream nullStream = Stream.empty();

        System.out.println("если вам потребовался стрим Collections.singleton(x).stream() из одного элемента, пишите просто Stream.of(x)");
        Stream singleStream = Stream.of(5);

        Set<String> ceo = Collections.singleton( new String( "Tim Cook" ) ) ;  // Always exactly one item in this context, only one CEO is possible.
        // ceo.add("Robocop") ;     // Fails, as the collection is immutable.
        // ceo.clear() ;      // Exception in thread "main" java.lang.UnsupportedOperationException
        // ceo.remove("Tim Cook") ;  // Fails, as the collection is immutable.
        System.out.println(ceo);

        System.out.println("Если вам стрим нужен, а не коллекция, так и создавайте сразу стрим:");
        Stream enumStream = EnumSet.of(x.one, x.two, x.tree).stream();
        enumStream.forEach(System.out::println);
        Stream simpleStream = Stream.of(1, 2, 3);
        simpleStream.forEach(System.out::println);

        System.out.println("Нужен стрим из N одинаково сгенерированных объектов?");
        Stream.generate(() -> new PhoneCollect("AnyPhone", "Comp", 100)).limit(3).forEach(s -> System.out.println(s.getName() + " " + s.getPrice()));

    }

    // В Java8 у интерфейса Iterable появился метод forEach, принимающий лямбда - выражение и применяющий это выражение на каждый элемент коллекции:
    static public Collection<String> collectionForEach (Collection<String> collectionForEach) {
        Collection<String> upper = new ArrayList<>();
        collectionForEach.forEach(s -> upper.add(s.toUpperCase()));
        return upper;
    }

    // Особенно удобно использовать forEach с Map
    static public Map<Integer, String> mapForEach (Map<Integer, String> mapForEach) {
        Map<Integer, String> upper = new HashMap<>();
        mapForEach.forEach((k, v) -> upper.put(k, v.toUpperCase()));
        return upper;
    }
}
