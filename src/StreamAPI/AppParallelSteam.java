package StreamAPI;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class AppParallelSteam {
    public static void main(String[] agrs) {
        /**
         * Чтобы сделать обычный последовательный поток параллельным, надо вызвать у объекта Stream метод parallel.
         * Кроме того, можно также использовать метод parallelStream() интерфейса Collection для создания параллельного потока из коллекции.
         * Прежде всего для точности вычисления функции должны быть без сохранения состояния и ассоциативными,
         * то есть при выполнении слева направо давать тот же результат, что и при выполнении справа налево, как в случае с произведением чисел.
         */

        System.out.println("Операция String (x,y) -> x + \" \" + y НЕявляется ассоциативной и может выдавать ошибки при паралельном вычислении.");
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
        String sentence = wordsStream.parallel().reduce("Результат:", (x,y) -> x + " " + y);
        System.out.println(sentence);

        System.out.println("Операция Integer (x,y) -> x * y является ассоциативной и поэтому может быть распараллелена.");
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Integer result = numbersStream.parallel().reduce(1, (x,y) -> x * y);
        System.out.println(result);

        /**
         * классу Arrays было добавлено ряд методов, которые позволяют в параллельном режиме совершать обработку элементов массива.
         * И хотя данные методы формально не входят в Stream API, но реализуют схожую функциональность, что и параллельные потоки:
         *
         * parallelPrefix(): вычисляет некоторое значение для элементов массива (например, сумму элементов)
         *
         * parallelSetAll(): устанавливает элементы массива с помощью лямбда-выражения
         *
         * parallelSort(): сортирует массив
         */

        System.out.println("Отсортируем массив чисел в параллельном режиме:");
        int[] nums = {30, -4, 5, 29, 7, -8};
        Arrays.parallelSort(nums);
        for(int i: nums)
            System.out.println(i);

        System.out.println("Используем метод parallelSetAll() для установки элементов массива:");
        int[] numbers = initializeArray(6);
        for(int i: numbers)
            System.out.println(i);

        System.out.println("Найдем произведение чисел:");
        int[] numbers2 = {1, 2, 3, 4, 5, 6};
        Arrays.parallelPrefix(numbers2, (x, y) -> x * y);

        for(int i: numbers2)
            System.out.println(i);

    }
    // функция перебирает все элементы и в качестве параметра получает индекс текущего перебираемого элемента
    public static int[] initializeArray(int size) {
        int[] values = new int[size];
        Arrays.parallelSetAll(values, i -> i*10);
        return values;
    }
}
