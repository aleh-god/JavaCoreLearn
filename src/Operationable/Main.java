package Operationable;

public class Main {
    public static void main(String[] args) {

        //Определение ссылки на функциональный интерфейс:
        Operationable operation;
        //Создание лямбда-выражения:
        operation = (x,y)->x+y;
        //Использование лямбда-выражения в виде вызова метода интерфейса:
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
        //При этом для одного функционального интерфейса мы можем определить множество лямбда-выражений.
        Operationable operation1 = (int x, int y)-> x + y;
        Operationable operation2 = (int x, int y)-> x - y;
        Operationable operation3 = (int x, int y)-> x * y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate(20, 10)); //10
        System.out.println(operation3.calculate(20, 10)); //200
    }
}
//Лямбда-выражение не выполняется само по себе, а образует реализацию метода, определенного в функциональном
// интерфейсе. При этом важно, что функциональный интерфейс должен содержать только один единственный метод без реализации.
interface Operationable{
    //определен один метод без реализации - метод calculate
    int calculate(int x, int y);
}