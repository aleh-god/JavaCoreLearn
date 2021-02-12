package StreamAPI;

/**
 * Ряд операций сведения, такие как min, max, reduce, findFirst и findAny возвращают объект Optional<T>. Этот объект фактически обертывает результат операции.
 * После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение
 */
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AppOptionalStream {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{13,21,3,40,55,61,17,85,93}));
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println("Optional<Integer> min: " + min.get());  // После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение

        /**
         * Обработка исключения java.util.NoSuchElementException, если поток не содержит вообще никаких данных:
         * isPresent() возврашает true, если значение присутствует в Optional, и false, если значение отсутствует:
         */
        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare); // Стандартный компаратор из класса Integer
        if(min.isPresent()){ //Предварительная проверка наличия значения в Optional с помощью метода isPresent().

            System.out.println(min.get());
        }

        /**
         * Метод orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из потока какого-нибудь значения:
         */
        // пустой список
        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare);
        System.out.println("пустой список + orElse(-1): " + min.orElse(-1)); //

        // непустой список
        numbers.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        min = numbers.stream().min(Integer::compare);
        System.out.println("непустой список: " + min.orElse(-1)); // 4

        /**
         * Метод orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию:
         */
        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare);
        Random rnd = new Random();
        System.out.println("значение по умолчанию: " + min.orElseGet(() -> rnd.nextInt(100))); // задать функцию -> случайное число

        /**
         * Метод ifPresent() определяет действия со значением в Optional, если значение имеется:
         */
        numbers.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        Optional<Integer>max = numbers.stream().max(Integer::compare);
        max.ifPresent(v -> System.out.println(".max.ifPresent: " + v)); // В метод ifPresent передается функция, которая принимает один параметр - значение из Optional.

        /**
         * В метод ifPresentOrElse передается две функции. Первая обрабатывает значение в Optional, если оно присутствует.
         * Вторая функция представляет действия, которые выполняются, если значение в Optional отсутствует
         */
        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare);
        min.ifPresentOrElse(
                v -> System.out.println(v),
                () -> System.out.println("Value not found")
        );

        /**
         метод - orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения:
         */
        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare);
        System.out.println(min.orElseThrow(IllegalStateException::new));

        /**
         * Как я писал выше, у Optional имеется неплохой инструментарий преобразования полученного объекта, а именно:
         *
         * get() — возвращает объект, если он есть.
         *
         * map() — преобразовывает объект в другой объект.
         *
         * filter() — фильтрует содержащиеся объекты по предикату.
         *
         * flatmap() — возвращает множество в виде стрима.
         */
    }
}
