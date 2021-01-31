package LambdaLearn2;

//Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не допускается.
public class LambdaAppType {

    public static void main(String[] args) {

                                    //Тело метода ФИ
        Operat<Integer> operation1 = (x, y)-> x + y;
        Operat<String> operation2 = (x, y) -> x + y;

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate("20", "10")); //2010
    }
}

//нам надо типизировать объект интерфейса определенным типом, который потом будет применяться в лямбда-выражении.
interface Operat<T>{
    //Сигнатура метода ФИ
    T calculate(T x, T y);
}