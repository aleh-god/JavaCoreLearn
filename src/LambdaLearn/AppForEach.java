package LambdaLearn;

import java.util.*;

public class AppForEach {

    public static void main(String[] args) {

        // forEach() и Set
        HashSet<String> phonesSet = new HashSet<String>();
        phonesSet.add("Мама");
        phonesSet.add("Папа");
        phonesSet.add("Сын");
        phonesSet.add("Дочь");
        phonesSet.add("Бабушка");
        phonesSet.add("Дедушка");

        phonesSet.forEach(System.out::println); // Ссылка на метод (method reference)

        // forEach() и Map
        Map<Integer, Integer> numbers = new HashMap<>();
        numbers.put(1, 100);
        numbers.put(2, 200);
        numbers.put(3, 300);
        numbers.put(4, 400);
        numbers.put(5, 500);

        numbers.forEach((k, v) -> {
            if (v > 250) { // forEach() с условием
                System.out.println("Key: " + k + " Value: " + v);
            }
        });

        // numbers.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }
}
