package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppCollectSteam {

    public static void main(String[] args) {

        /**
         * !!!
         * метод collect. Первая версия метода принимает в качестве параметра функцию преобразования к коллекции. .collect(здесь помещаем любой метод преобразования, готовый или самописный)
         * !!!
         *
         * Эта функция представляет объект Collector, который определен в пакете java.util.stream.
         * Мы можем написать свою реализацию функции, однако Java уже предоставляет ряд встроенных функций, определенных в классе Collectors:
         *
         * toList(): преобразование к типу List
         * toSet(): преобразование к типу Set
         * toMap(): преобразование к типу Map
         * Collectors.toCollection(LinkedList::new) - любую другую коллекцию, используя класс Collectors
         *
         * Collectors.toCollection - collect принимает лямбда-выражение известное как коллектор (Collector), которое собирает данные в необходимую структуру данных.
         * Метод toCollection принимает лямбда-выражение типа поставщик (Supplier), которое должно вернуть коллекцию, в которую мы хотим сохранить данные. В данном случае мы вернули LinkedList.
         * Пример так же можно улучшить с помощю ссылки на метод, изменив
         * Java
         * Collectors.toCollection(() -> new LinkedList<>())
         * На
         * Collectors.toCollection(LinkedList::new)
         */

        List<String> phones = new ArrayList<String>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        List<String> filteredPhones = phones.stream() // Создаем поток из ArrayList
                .filter(s -> s.length() < 15) // Фильтруем по условию
                .collect(Collectors.toList()); // Преобразуем поток в коллекцию List, передавая в качеств епараметра метод преобразования: Collectors - класс .toList() - метод преобразования

        System.out.println("Преобразуем набор в потоке в список toList():");
        for (String s : filteredPhones) {
            System.out.print(s + ", ");
        }

        // phones - готовый List с данными, который можно брать каждый раз для создания потока
        Set<String> filteredPhonesSet = phones.stream()
                .filter(s -> s.length() < 15)
                .collect(Collectors.toSet());

        System.out.println("\nПреобразуем набор в потоке в уникальный сет toSet():");
        for (String s : filteredPhonesSet) {
            System.out.print(s + ", ");
        }

        System.out.println("\nПреобразуем набор в потоке в словарь (k,v) .toMap():");

        // Здесь создаем поток из набора значений, и его нужно создавать каждый раз:
        Stream<PhoneCollect> phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        Map<String, Integer> phonesMap = phoneStreamMap
                .collect(Collectors.toMap(p -> p.getName(), t -> t.getPrice())); // Лямбда-выражение p->p.getName() получает значение для ключа элемента, а t->t.getPrice() - извлекает значение элемента.
        phonesMap.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("\nПреобразуем в определенный тип коллекции HashSet:");
        // Здесь создаем поток из набора значений, и его нужно создавать каждый раз:
        Stream<String> phonesHashSet = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        HashSet<String> filteredPhonesHashSet = phonesHashSet.filter(s -> s.length() < 12).
                // It returns a Collector that accumulates the input elements into a new Collection
                collect(Collectors.toCollection(HashSet::new)); // Collectors.toCollection(() -> new HashSet<>())
                                                                // HashSet::new представляет функцию создания коллекции
        filteredPhonesHashSet.forEach(s -> System.out.println(s + " "));

        System.out.println("\nПреобразуем в определенный тип коллекции ArrayList:");
        // Здесь создаем поток из набора значений, и его нужно создавать каждый раз:
        Stream<String> phonesArrayList = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");
        ArrayList<String> result = phonesArrayList.collect(Collectors.toCollection(ArrayList::new));
        result.forEach(s -> System.out.println(s + " "));

        /**
         * Вторая форма метода collect имеет три параметра:
         * supplier: создает объект коллекции
         *
         * accumulator: добавляет элемент в коллекцию
         *
         * combiner: бинарная функция, которая объединяет два объекта
         */

        System.out.println("\nВторая форма метода collect:");
        Stream<String> phones2 = Stream.of("iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        ArrayList<String> filteredPhones2 = phones2.filter(s -> s.length() < 12)
                .collect(
                        () -> new ArrayList<String>(), // создаем ArrayList
                        (list, item) -> list.add(item), // добавляем в список элемент
                        (list1, list2) -> list1.addAll(list2)); // добавляем в список другой список

        filteredPhones2.forEach(s -> System.out.println(s));

        /**
         * Чтобы сгруппировать данные по какому-нибудь признаку, нам надо использовать в связке метод collect() объекта Stream и метод Collectors.groupingBy()
         */

        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("у нас есть набор объектов Phone, которые мы хотим сгруппировать по компании: ");
        // объект Map, в котором ключами являются названия компаний, а значениями - список связанных с компаниями телефонов.
        Map<String, List<PhoneCollect>> phonesByCompany = phoneStreamMap.collect( // В метод phoneStream.collect() передается вызов функции Collectors.groupingBy(),
                Collectors.groupingBy(PhoneCollect::getCompany)); // которая с помощью выражения Phone::getCompany = () -> Phone.getCompany группирует объекты по компании.

        //  Все элементы словаря представляют объект Map.Entry // entrySet() - преобразует словарь в коллекцию значений
        for (Map.Entry<String, List<PhoneCollect>> item : phonesByCompany.entrySet()) {

            System.out.println(item.getKey()); // Ключ словаря - название компании
            for (PhoneCollect phone : item.getValue()) { // Map.Entry.getValue(): возвращает значение объекта отображения -> List<PhoneCollect>

                System.out.println(phone.getName());
            }
            System.out.println();
        }

        /**
         * Метод Collectors.partitioningBy() имеет похожее действие, только он делит элементы на группы по принципу, соответствует ли элемент определенному условию.
         */

        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("С помощью условия p->p.getCompany()==\"Apple\" мы разделяем поток и преобразуем в словарь с двумя списками:");
        Map<Boolean, List<PhoneCollect>> phonesPartitioningBy = phoneStreamMap.collect(
                Collectors.partitioningBy(p -> p.getCompany()=="Apple"));

        for(Map.Entry<Boolean, List<PhoneCollect>> item : phonesPartitioningBy.entrySet()){

            System.out.println(item.getKey());
            for(PhoneCollect phone : item.getValue()){

                System.out.println(phone.getName());
            }
            System.out.println();
        }

        /**
         * Метод Collectors.counting применяется в Collectors.groupingBy() для вычисления количества элементов в каждой группе:
         */

        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );
        System.out.println("Вычисления количества элементов в каждой группе:");
        Map<String, Long> phonesByCompanyC = phoneStreamMap.collect(
                Collectors.groupingBy(PhoneCollect::getCompany, Collectors.counting())); // Группируем по getCompany и считаем счетчиками -> Выходом потока будет словарь из значения и счетчика

        for(Map.Entry<String, Long> item : phonesByCompanyC.entrySet()){

            System.out.println(item.getKey() + " - " + item.getValue());
        }

        /**
         * Метод Collectors.summing применяется для подсчета суммы.
         * В зависимости от типа данных, к которым применяется метод, он имеет следующие формы:
         * summingInt(), summingLong(), summingDouble().
         */
        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("Для каждой компании вычислим совокупную цена всех ее смартфонов:");
                                                            // .collect преобразует поток в Map<>
        Map<String, Integer> phonesByCompanyS = phoneStreamMap.collect(
                // .groupingBy - группирует поток через (параметр);
                                    // Параметр getCompany      // Элементы в потоке суммируем по getPrice
                Collectors.groupingBy(PhoneCollect::getCompany, Collectors.summingInt(PhoneCollect::getPrice)));

        for(Map.Entry<String, Integer> item : phonesByCompanyS.entrySet()){

            System.out.println(item.getKey() + " - " + item.getValue());
        }

        /**
         * Методы maxBy и minBy применяются для подсчета минимального и максимального значения в каждой группе.
         * В качестве параметра эти методы принимают функцию компаратора, которая нужна для сравнения значений.
         */

        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("Найдем для каждой компании телефон с минимальной ценой:");
        // поскольку группируем по компаниям, то ключом будет выступать строка, а значением - объект Optional<Phone>.
        Map<String, Optional<PhoneCollect>> phonesByCompanyMax = phoneStreamMap.collect(
                Collectors.groupingBy(PhoneCollect::getCompany,
                        Collectors.minBy(Comparator.comparing(PhoneCollect::getPrice)))); // В качестве параметра эти методы принимают функцию компаратора, которая нужна для сравнения значений.

        for(Map.Entry<String, Optional<PhoneCollect>> item : phonesByCompanyMax.entrySet()){

                                                    // Берем K-значение из .Entry(v,k)
                                                                    // Это Optional поэтому берем из контейнера значение через .get()
                                                                            // Это объект PhoneCollect берем из объекта имя через .getName()
            System.out.println(item.getKey() + " - " + item.getValue().get().getName());
        }

        /**
         * Методы summarizingInt() / summarizingLong() / summarizingDouble() позволяют объединить в набор значения соответствующих типов.
         * Данный наборы инкапсулируется в объектах IntSummaryStatistics / LongSummaryStatistics / DoubleSummaryStatistics соответственно.
         * У этих объектов есть ряд методов, который позволяют выполнить различные атомарные операции над набором:
         * getAverage(): возвращает среднее значение
         * getCount(): возвращает количество элементов в наборе
         * getMax(): возвращает максимальное значение
         * getMin(): возвращает минимальное значение
         * getSum(): возвращает сумму элементов
         * accept(): добавляет в набор новый элемент
         */

        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("Получаем среднюю цену смартфонов для каждой группы:");
        Map<String, IntSummaryStatistics> priceSummary = phoneStreamMap.collect(
                Collectors.groupingBy(PhoneCollect::getCompany,
                        Collectors.summarizingInt(PhoneCollect::getPrice)));

        for(Map.Entry<String, IntSummaryStatistics> item : priceSummary.entrySet()){

            System.out.println(item.getKey() + " - " + item.getValue().getAverage());
        }

        /**
         * Метод mapping позволяет дополнительно обработать данные и задать функцию отображения объектов из потока на какой-нибудь другой тип данных. Например:
         */
        phoneStreamMap = Stream.of(
                new PhoneCollect("iPhone X", "Apple", 600),
                new PhoneCollect("Pixel 2", "Google", 500),
                new PhoneCollect("Pixel 1", "Google", 200),
                new PhoneCollect("iPhone 8", "Apple", 450),
                new PhoneCollect("Galaxy S9", "Samsung", 440),
                new PhoneCollect("Galaxy S8", "Samsung", 340)
        );

        System.out.println("В группу будут выделятся названия смартфонов по названием компаний:");
        Map<String, List<String>> phonesByCompanyM = phoneStreamMap.collect(
                Collectors.groupingBy(PhoneCollect::getCompany,
                        // Выражение Collectors.mapping(Phone::getName, Collectors.toList()) указывает, что в группу будут выделятся названия смартфонов, причем группа будет представлять объект List.
                        Collectors.mapping(PhoneCollect::getName, Collectors.toList())));

        for(Map.Entry<String, List<String>> item : phonesByCompanyM.entrySet()){

            System.out.println(item.getKey());
            for(String name : item.getValue()){
                System.out.println(name);
            }
        }
    }
}

class PhoneCollect{

    private String name;
    private String company;
    private int price;

    public PhoneCollect(String name, String comp, int price){
        this.name=name;
        this.company=comp;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCompany() { return company; }
}
