package LambdaFunctionLearn;
import java.util.function.Predicate;

public class LambdaAppPredicate {

    public static void main(String[] args) {

        // Функциональный интерфейс Predicate<T> уже создан в импортируемой утилите java
        // Его не нужно описывать в ФИ - boolean test(T t);
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
    }
}