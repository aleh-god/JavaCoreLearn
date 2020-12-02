package Operationable;

//пример - использования переменных уровня класса
public class LambdaApp {

    //Локальные переменные, которые объявлены во вне в более общей области видимости - на уровне класса
    static int x = 10;
    static int y = 20;
    //Локальные переменные уровня метода мы также можем использовать в лямбдах, но изменять их значение нельзя
    int n = 70;
    public static void main(String[] args) {

        Operation op = ()->{

            //n=100; - так нельзя сделать

            //В лямбда-выражении мы их можем получить и даже изменить.
            x=30;
            return x+y;
        };

        // n=100;  - так тоже нельзя

        System.out.println(op.calculate()); // 50
        System.out.println(x); // 30 - значение x изменилось
    }
}
interface Operation{
    int calculate();
}
