package LambdaLearn;

import java.util.function.Supplier;

public class LambdaAppSupplier {
    public static void main(String[] args) {
        String t = "One";
        Supplier<String> supplierStr = () -> t.toUpperCase();
        System.out.println(supplierStr.get());
    }
}

//Интерфейс Supplier используется тогда, когда на вход не передаются значения, но необходимо вернуть результат.
//@FunctionalInterface
//interface Supplier<T> {
//    T get();
//}
