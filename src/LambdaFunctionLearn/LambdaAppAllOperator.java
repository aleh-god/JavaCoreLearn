package LambdaFunctionLearn;
// Функциональный интерфейс уже создан в импортируемой утилите java.util.function
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.Scanner;
import java.util.function.Supplier;

public class LambdaAppAllOperator {

    public static void main(String[] args) {

        //Нужно только импортировать нужный ФИ и прописать тело метода.

        //BinaryOperator<T> принимает в качестве параметра два объекта типа T, выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        //UnaryOperator<T> принимает в качестве параметра объект типа T, выполняет над ними операции и возвращает результат операций в виде объекта типа T:
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25

        //Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:
        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов

        //Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        //Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T: T get();
        Supplier<User> userFactory = ()->{

            //Создаем объект потока-сканера из консоли
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