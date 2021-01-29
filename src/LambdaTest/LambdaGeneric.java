package LambdaTest;

public class LambdaGeneric {
    public static void main(String[] args) {
        //При объявлении лямбда-выражения ему уже известно, какой тип параметры будут представлять и какой тип они будут возвращать.
        GenLambda<Integer> app;
        app = (x, y) -> x * y;

        GenLambda<Double> app2;
        app2 = (x, y) -> x * y;
        System.out.println("Результат:");
        System.out.println(app.sum(5, 6));
        System.out.println(app2.sum(10.0, 6.0));
    }
}

//Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не допускается.
//В этом случае нам надо типизировать объект интерфейса определенным типом, который потом будет применяться в лямбда-выражении.
interface GenLambda<T> {
    T sum(T a , T b);
}
