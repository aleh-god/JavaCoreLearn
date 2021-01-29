package LambdaTest;

public class LambdaVoid {
    public static void main(String[] args) {
        TerminalL lambdaApp;

        lambdaApp = () -> System.out.println("могут быть и терминальные лямбды,");
        lambdaApp.printable();
        lambdaApp = () -> System.out.println("которые не возвращают никакого значения");
        lambdaApp.printable();

    }
}

interface TerminalL {
    //Метод может не возвращать значения и не принимать переменные
    void printable();
}