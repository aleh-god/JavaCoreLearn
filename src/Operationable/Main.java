package Operationable;

public class Main {
    public static void main(String[] args) {

        //Определение ссылки на функциональный интерфейс:
        Operationable operation;
        //Создание лямбда-выражения:
        operation = (x,y,z)->(x+y)/z;
        //Использование лямбда-выражения в виде вызова метода интерфейса:
        double result = operation.calculate(10, 20, 4);
        System.out.println(result); //30

        //При этом для одного функционального интерфейса мы можем определить множество лямбда-выражений.
                                //Вход со стороны основного кода
                                                        //Тело метода ФИ
        Operationable operation1 = (int x, int y, int z)-> (x + y) * z;
        Operationable operation2 = (int x, int y, int z)-> (x + y) / z;
        Operationable operation3 = (int x, int y, int z)-> x * y * z;

        System.out.println(operation1.calculate(20, 10, 3)); //
        System.out.println(operation2.calculate(22, 11, 2)); //
        System.out.println(operation3.calculate(20, 10, 0)); //
    }
}
//Лямбда-выражение не выполняется само по себе, а образует реализацию метода, определенного в функциональном
// интерфейсе. При этом важно, что функциональный интерфейс должен содержать только один единственный метод без реализации.
interface Operationable{
    //Сигнатура метода ФИ - выход, название, вход
    double calculate(int x, int y, int z);
}