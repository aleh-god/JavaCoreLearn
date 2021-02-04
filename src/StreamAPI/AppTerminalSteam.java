package StreamAPI;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.*;

/**
 * При работе со Stream API важно понимать, что все операции с потоками бывают либо терминальными (terminal), либо промежуточными (intermediate).\
 * Промежуточные операции возвращают трансформированный поток. Например, выше в примере метод filter принимал поток чисел и возвращал уже преобразованный поток,
 * в котором только числа больше 0. К возвращенному потоку также можно применить ряд промежуточных операций.
 *
 * Конечные или терминальные операции возвращают конкретный результат. Например, в примере выше метод count() представляет терминальную операцию и возвращает число.
 * После этого никаких промежуточных операций естественно применять нельзя.
 *
 * Все потоки производят вычисления, в том числе в промежуточных операциях, только тогда, когда к ним применяется терминальная операция.
 * То есть в данном случае применяется отложенное выполнение.
 */

public class AppTerminalSteam {

    public static void main(String[] args) {

        ArrayList<String> namesData = new ArrayList<String>();
        namesData.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice", "Kenwood", "Napoleon"}));

         // Создаем поток Stream из перечисления объектов names
        // Для удобства поток Stream помещаем в функц интерфейс Supplier, где можем выдавать новый поток для каждого выражения SteamAPI.
        Supplier<Stream> getNameStream = () -> namesData.stream();

        // Задаем переменную потоков для примеров.
        Stream nameStream;
        // Выдаем новый поток для выражения SteamAPI.
        nameStream = getNameStream.get();

        /**
         * forEach
         */

        //Для перебора элементов потока применяется метод forEach(), который представляет терминальную операцию:
        System.out.println("Метод forEach() - перебор элементов потока:");
        nameStream.forEach(s -> System.out.print(s + " "));

        /**
         * count
         */

        // Выдаем новый поток для выражения SteamAPI.
        nameStream = getNameStream.get();
        System.out.print("\nМетод count() возвращает количество элементов в потоке данных: ");
        long i = nameStream.count();
        System.out.println(i);

        ArrayList<String> names2 = new ArrayList<String>();
        names2.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        System.out.println("Количество элементов с длиной не больше 3 символов:");
        System.out.println(names2.stream().filter(n -> n.length() <= 3).count());  // 3
        //System.out.println(nameStream.filter(n -> n.length() <= 3).count());  // Почему-то не сработал через функц интерфейс

        /**
         * findFirst и findAny
         */

        // Выдаем новый поток для выражения SteamAPI.
        nameStream = getNameStream.get();

        System.out.println("Метод findFirst() извлекает из потока первый элемент:");
        System.out.println(nameStream.findFirst());    // Tom

        // Выдаем новый поток для выражения SteamAPI.
        nameStream = getNameStream.get();

        System.out.println("Метод findAny() извлекает случайный объект из потока (нередко так же первый):");
        //Optional<String> any = nameStream.findAny(); // Используем функц интерфейс
        System.out.println(nameStream.findAny());    // Tom

        OptionalInt any2 = Arrays.stream(new int[] {3, 5, 6, 7, 82, 44, 6}).findAny();
        System.out.println("{3, 5, 6, 7, 82, 44, 6}.findAny() = " + any2.getAsInt());

        /**
         * allMatch, anyMatch, noneMatch
         */

        // Выдаем новый поток для выражения SteamAPI.
        nameStream = getNameStream.get();

        //boolean noneMatch(Predicate<? super T> predicate): возвращает true, если ни один из элементов в потоке не удовлетворяет условию в предикате
        boolean none = nameStream.noneMatch(s -> s == "Bill");
        System.out.println("НЕТ ЛИ в потоке строки \"Bill\". Если нет, то true, если есть, то false: " + none);   // true

        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        //boolean anyMatch(Predicate<? super T> predicate): возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
        boolean any = names.stream().anyMatch(s -> s.length()>3);
        System.out.println("есть ли в потоке строка, длина которой больше 3: " + any);    // true

        //boolean allMatch(Predicate<? super T> predicate): возвращает true, если все элементы потока удовлетворяют условию в предикате
        boolean all = names.stream().allMatch(s -> s.length()==3);
        System.out.println("все ли строки имеют длину в 3 символа: " + all);    // false

        /**
         * Методы min() и max() возвращают соответственно минимальное и максимальное значение.
         * Поскольку данные в потоке могут представлять различные типы, в том числе сложные классы,
         * то в качестве параметра в эти методы передается объект интерфейса Comparator, который указывает, как сравнивать объекты:
         */

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{10,2,3,4,5,66,7,8,9}));

        // Оба метода возвращают элемент потока (минимальный или максимальный), обернутый в объект Optional.
        Optional<Integer> min = numbers.stream().min(Integer::compare); // Используем стандартный компаратор
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println("{10,2,3,4,5,66,7,8,9} минимальный: " + min.get());  // чтобы получить непосредственно результат операции из Optional, необходимо вызвать метод get().
        System.out.println("{10,2,3,4,5,66,7,8,9} максимальный: " + max.get());  // чтобы получить непосредственно результат операции из Optional, необходимо вызвать метод get().

        /**
         * Метод reduce выполняет терминальные операции сведения, возвращая некоторое значение - результат операции. Он имеет следующие формы:
         * Первая форма возвращает результат в виде объекта Optional<T>.
         * Вторая версия метода reduce() принимает два параметра: T reduce(T identity, BinaryOperator<T> accumulator)
         *
         */


        Optional<Integer> result = numbers.stream().reduce((x,y) -> x*y); // Производит умножение конвеерно - результат со следующим значением
        System.out.println("произведение набора чисел: " + result.get()); // из Optional, необходимо вызвать метод get().

        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y);
        System.out.println("x + \" \" + y объединение слов в предложение: " + sentence.get());

        // здесь выполняется следующая цепь операций: identity op n1 op n2 op n3 op n4...
        Stream<Integer> numberStream = Stream.of(-4, 3, -2, 1);
        int identity = 10; // Стартовая позиция для выполнения первого варианта функции
        int resultIdentity = numberStream.reduce(identity, (x,y) -> x + y);
        System.out.println("(-4, 3, -2, 1 ) reduce(identity(10)) = " + resultIdentity);  // 24

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 64000),
                new Phone("LG G 4", 32000));

        // Для этого используем третью версию метода reduce
        int sum = phoneStream.reduce(0, // Опять же здесь в качестве первого параметра идет значение по умолчанию - 0.
                (x,y) -> { //Второй параметр производит бинарную операцию, которая получает промежуточное значение - суммарную цену текущего и предыдущего телефонов.
                    if(y.getPrice()<50000)
                        return x + y.getPrice();
                    else
                        return x + 0;
                },
                (x, y) -> x+y); // Третий параметр представляет бинарную операцию, которая суммирует все промежуточные вычисления.

        System.out.println("сумму цен тех телефонов, у которых цена меньше определенного значения: " + sum); // 117000
    }
}
