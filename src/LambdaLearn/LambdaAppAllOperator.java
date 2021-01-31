package LambdaLearn;

// Функциональный интерфейс уже создан в импортируемой утилите java.util.function
// Нужно только импортировать нужный ФИ и прописать тело метода.

import java.util.function.*;
import java.util.Scanner;

public class LambdaAppAllOperator {

    public static void main(String[] args) {

        System.out.println("Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия. Если оно соблюдается, то возвращается значение true.");
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false

        System.out.println("BinaryOperator<T> принимает в качестве параметра два объекта типа T, выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:");
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        System.out.println("UnaryOperator<T> принимает в качестве параметра объект типа T, выполняет над ними операции и возвращает результат операций в виде объекта типа T:");
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25

        System.out.println("Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:");
        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов

        System.out.println("Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:");
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        System.out.println("Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T: T get();");
        Supplier<User> userFactory = ()->{


            System.out.println("Создаем объект потока-сканера из консоли");
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            //Считваем всю строку
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }
}

class User{

    private String name;
    String getName(){
        return name;
    }

    User(String n){
        this.name=n;
    }
}