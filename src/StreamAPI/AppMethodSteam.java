package StreamAPI;

import java.util.stream.Stream;

public class AppMethodSteam {
    public static void main(String[] args) {

        //Для перебора элементов потока применяется метод forEach(), который представляет терминальную операцию:
        System.out.println("метод forEach() - перебор элементов потока:");
        Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель").forEach(s -> System.out.print(s + " "));

        //Для фильтрации элементов в потоке применяется метод filter(), который представляет промежуточную операцию.
        // Он принимает в качестве параметра некоторое условие в виде объекта Predicate<T> и возвращает новый поток из элементов, которые удовлетворяют этому условию:
        System.out.println("\nметод filter() - Для фильтрации элементов в потоке:");
        Stream.of("Париж", "Лондон", "Мадрид", "Берлин", "Брюссель").filter(s->s.length()==6).forEach(System.out::println); // Короткое описание примитивного вывода на консоль

        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000)
        );

        System.out.println("\nметод filter() - в работе со сложными объектами и условиями:");
        // (Входящие данные - phoneStream).(Для каждого элемента цена которого менше 50000).(Для всех элементов - вывести на консоль название)
        phoneStream.filter(p -> p.getPrice() < 50000).forEach(p -> System.out.println(p.getName()));

        //Передаваемая в метод map функция задает преобразование от объектов типа T к типу R. И в результате возвращается новый поток с преобразованными объектами.
        Stream<Phone> phoneStream2 = Stream.of( // phoneStream - выполнен и закрыт, нужно создать новый поток.
                new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000)
        );
        System.out.println("\nметод map() - выполним преобразование от типа Phone к типу String:");
        phoneStream2.map(p-> p.getName()).forEach(s->System.out.println(s));  // помещаем в поток только названия телефонов

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
