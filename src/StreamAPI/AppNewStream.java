package StreamAPI;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.*;

public class AppNewStream {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид", "Rome");

        cities.stream() // получаем поток, который использует данные из списка cities
                .filter(s -> s.length() == 6) // применяем фильтрацию по длине строки .length()
                .forEach(s -> System.out.print(s + " ")); // выводим отфильтрованные строки на консоль

        System.out.println("");
        // Например, мы можем изменить предыдущий пример следующим образом:
        Stream<String> citiesStream = cities.stream(); // получаем на super-переменную (Stream для любых типов потоков) поток ArrayList<String>
                citiesStream = citiesStream.filter(s -> s.length() > 3); // применяем фильтрацию по длине строки
                citiesStream.forEach(s -> System.out.print(s + " ")); // выводим все .forEach отфильтрованные строки на консоль

        System.out.println("");

        //Один из таких способов представляет метод Arrays.stream(T[] array), который создает поток данных из массива:
        System.out.println("Поток данных из массива <String>:");
        Stream<String> arraysStream = Arrays.stream(new String[]{"Париж", "Лондон", "Мадрид"}) ;
        arraysStream.forEach(s->System.out.print(s + " ")); // выводим все элементы массива

        System.out.println("");
        System.out.println("Поток данных из массива <int>:");
        IntStream intStream = Arrays.stream(new int[]{1,2,4,5,7});
        intStream.forEach(i->System.out.print(i + " "));

        System.out.println("");
        System.out.println("Поток данных из массива <long>:");
        LongStream longStream = Arrays.stream(new long[]{100,250,400,5843787,237});
        longStream.forEach(l->System.out.print(l + " "));

        System.out.println("");
        System.out.println("Поток данных из массива <double>:");
        DoubleStream doubleStream = Arrays.stream(new double[] {3.4, 6.7, 9.5, 8.2345, 121});
        doubleStream.forEach(d->System.out.print(d + " "));

        System.out.println("Еще один способ создания потока представляет статический метод of(T..values) класса Stream:");
        Stream<String> citiesStr =Stream.of("Париж", "Лондон", "Мадрид");
        citiesStr.forEach(s->System.out.println(s));

        System.out.println("Можно передать массив String[] через переменную в поток String.of:");
        String[] citiesMass = {"Париж", "Лондон", "Мадрид"};
        Stream<String> citiesStream2 = Stream.of(citiesMass);

        System.out.println("Массив int[] через переменную в поток IntStream.of:");
        IntStream intStream2 = IntStream.of(1,2,4,5,7);
        intStream2.forEach(i->System.out.println(i));

        System.out.println("Массив long[] через переменную в поток LongStream.of:");
        LongStream longStream2 = LongStream.of(100,250,400,5843787,237);
        longStream2.forEach(l->System.out.println(l));

        System.out.println("Массив double[] через переменную в поток DoubleStream.of:");
        DoubleStream doubleStream2 = DoubleStream.of(3.4, 6.7, 9.5, 8.2345, 121);
        doubleStream2.forEach(d->System.out.println(d));

    }
}

