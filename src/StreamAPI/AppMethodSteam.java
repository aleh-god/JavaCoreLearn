package StreamAPI;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * При работе со Stream API важно понимать, что все операции с потоками бывают либо терминальными (terminal), либо промежуточными (intermediate).
 * Промежуточные операции возвращают трансформированный поток. Например, выше в примере метод filter принимал поток чисел и возвращал уже преобразованный поток,
 * в котором только числа больше 0. К возвращенному потоку также можно применить ряд промежуточных операций.
 *
 * Конечные или терминальные операции возвращают конкретный результат. Например, в примере выше метод count() представляет терминальную операцию и возвращает число.
 * После этого никаких промежуточных операций естественно применять нельзя.
 *
 * Все потоки производят вычисления, в том числе в промежуточных операциях, только тогда, когда к ним применяется терминальная операция.
 * То есть в данном случае применяется отложенное выполнение.
 */

public class AppMethodSteam {
    public static void main(String[] args) {

        //Для перебора элементов потока применяется метод forEach(), который представляет терминальную операцию:
        System.out.println("метод forEach() - перебор элементов потока:");
        Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель").forEach(s -> System.out.print(s + " "));

        //Для фильтрации элементов в потоке применяется метод filter(), который представляет промежуточную операцию.
        // Он принимает в качестве параметра некоторое условие в виде объекта Predicate<T> и возвращает новый поток из элементов, которые удовлетворяют этому условию:
        System.out.println("\nметод filter() - Для фильтрации элементов в потоке length()==6:");
        Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель").filter(s -> s.length()==6).forEach(System.out::println); // Короткое описание примитивного вывода на консоль

        // Создаем поток Stream из перечисления объектов Phone
        // Для удобства поток Stream помещаем в функц интерфейс Supplier, где можем выдавать новый поток для каждого выражения SteamAPI.
        Supplier<Stream<Phone>> getPhoneStream = () -> Stream.of(
                new Phone("iPhone 6S", 54000),
                new Phone("iPhone 7 ", 60000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S6", 40000)
        );

        // Задаем переменную для потоков для примеров.
        Stream<Phone> phoneStream;
        // Выдаем новый поток для выражения SteamAPI.
        phoneStream = getPhoneStream.get();

        System.out.println("\nметод filter() - в работе со сложными объектами и условиями:");
        // (Входящие данные - phoneStream).(Для каждого элемента цена которого менше 50000).(Для всех элементов - вывести на консоль поле Name)
        phoneStream.filter(p -> p.getPrice() < 50000).forEach(p -> System.out.println(p.getName() + ", Price < 50 000"));

        // Выдаем новый поток для выражения SteamAPI.
        phoneStream = getPhoneStream.get();

        //Передаваемая в метод map функция задает преобразование от объектов типа T к типу R. И в результате возвращается новый поток с преобразованными объектами.
        System.out.println("\nметод map() - выполним преобразование от типа Phone к типу String:");
        // Поток объектов. преобразуем в поток Name. выводим на консоль
        phoneStream.map(p -> p.getName()).forEach(s -> System.out.println(s));  // помещаем в поток только названия телефонов

        // Выдаем новый поток для выражения SteamAPI.
        phoneStream = getPhoneStream.get();
        System.out.println("\nметод map() - теперь названия соединяются с ценами:");
        phoneStream
                .map(p-> "название: " + p.getName() + " цена: " + p.getPrice())
                .forEach(s -> System.out.println(s));

        // Выдаем новый поток для выражения SteamAPI.
        phoneStream = getPhoneStream.get();
        System.out.println("\nПлоское отображение выполняется тогда, когда из одного элемента нужно получить несколько. Данную операцию выполняет метод flatMap:");
        // Из одного объекта Phone нам надо получить два объекта с информацией
        phoneStream
                .flatMap(p->Stream.of( // Из одного потока делаем два
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()), // метод .format класса String возвращает строку = текст с параметрами и через запятую примитивы.
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1)) // К цене добавляем вычисление скидки
                ))
                .forEach(s -> System.out.println(s)); // Каждый из потоков выводим на консоль

        // Выдаем новый поток для выражения SteamAPI.
        phoneStream = getPhoneStream.get();

        /**
        phoneStream.flatMap(p -> Stream.of(
                Stream.of(p.getPrice()).filter(i -> i > 50000),
                Stream.of(p.getPrice()).filter(i -> i < 50000)
        )).forEach(s -> System.out.print(" " + s));
        */

        /**
         * сортировку мы можем задействовать, когда у нас идет набор промежуточных операций с потоком, которые создают новые наборы данных, и нам надо эти наборы отсортировать.
         * данный метод подходит только для сортировки тех объектов, которые реализуют интерфейс Comparable.
         */

        List<String> phonesList = new ArrayList<String>();
        // Статистический метод абстрактного класса .addAll - добавляет значения в phonesList
        Collections.addAll(phonesList, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");

        System.out.println("Для простой сортировки по возрастанию применяется метод sorted():");
        phonesList.stream()
                .filter(p->p.length()<12)
                .sorted() // сортировка по возрастанию
                .forEach(s->System.out.println(s));

        /**
         * Метод takeWhile() выбирает из потока элементы, пока они соответствуют условию.
         * Если попадается элемент, который не соответствует условию, то метод завершает свою работу.
         * Выбранные элементы возвращаются в виде потока.
         */

        System.out.println("\nМетод skip(long n) используется для пропуска n элементов. Этот метод возвращает новый поток, в котором пропущены первые n элементов:");
        Stream<Integer> numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.skip(2)
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nМетод limit(long n) применяется для выборки первых n элементов потоков. Этот метод также возвращает модифицированный поток, в котором не более n элементов.");
        numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.limit(2)
                .forEach(n -> System.out.print(n + " "));


        System.out.println("\nМетод takeWhile() выбирает из потока элементы, пока они соответствуют условию:");
        numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.takeWhile(n -> n < 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nЧтобы в данном случае охватить все элементы, которые меньше нуля, поток следует предварительно отсортировать:");
        numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.sorted().takeWhile(n -> n < 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nМетод dropWhile() выполняет обратную задачу - он пропускает элементы потока, которые соответствуют условию до тех пор, пока не встретит элемент, который НЕ соответствует условию:");
        numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.sorted().dropWhile(n -> n < 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println("\nСтатический метод concat() объединяет элементы двух потоков, возвращая объединенный поток:");
        Stream<String> people1 = Stream.of("Tom", "Sam", "Bob", "Sam");
        Stream<String> people2 = Stream.of("Alice", "Kate", "Kate", "Sam");
        Stream.concat(people1, people2).forEach(n -> System.out.print(n + " "));

        System.out.println("\nМетод distinct() возвращает только уникальные элементы в виде потока:");
        Stream<String> people = Stream.of("Tom", "Sam", "Bob", "Sam", "Alice", "Kate", "Kate", "Sam");
        people.distinct().forEach(p -> System.out.print(p + " "));

        System.out.println("\nПример постраничной навигации:");
        List<String> phones = new ArrayList<String>();
        phones.addAll(Arrays.asList(new String[]
                {"iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
                        "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
                        "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
                        "Lenovo S 850"}));

        int pageSize = 3; // количество элементов на страницу
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("Введите номер страницы. Если число меньше 1, то выход:");
            int page = scanner.nextInt();

            if(page<1) break; // если число меньше 1, выходим из цикла

            phones.stream().skip((page-1) * pageSize) // Определяем от какой страницы отображать и пропускаем
                    .limit(pageSize) // Показываем ровно в размер одной страницы
                    .forEach(s->System.out.println(s));
        }
    }
}

class Phone{

    private String name;
    private int price;

    public Phone(String name, int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
