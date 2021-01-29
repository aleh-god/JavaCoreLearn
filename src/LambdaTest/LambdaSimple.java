package LambdaTest;

public class LambdaSimple {
    public static void main(String[] args) {
        //3. Создаем ссылку
        Operationable lambdaApp;
        //4. Определяем тело функц метода
        lambdaApp = (x, y) -> x + y;
        //5. Использование лямбда-выражения в виде вызова метода интерфейса
        int result = lambdaApp.operation(5, 4);
        System.out.println("x + y = " + result);

        lambdaApp = (x, y) -> x * y;
        result = lambdaApp.operation(5, 4);
        System.out.println("x * y = " + result);

        Operationable lambdaApp2;
        lambdaApp2 = (x, y) -> x - y;
        System.out.println("№ = " + lambdaApp2.operation(10, 4) + lambdaApp.operation(2, 3));
    }
}
//1. Определяем функц интерфейс лямбды
interface Operationable {
    //2. Определяем сигнатуру -> <тип>имя(параметр); - функц метода
    int operation(int a, int b);
}
