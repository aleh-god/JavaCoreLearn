package RecursionLearn;

public class main {
    public static void main(String[] agrs) {
        Factorial f = new Factorial();
        int usernumber = 4;
        // вычисляем факториал и выводим результат в текстовой метке
        System.out.println("Факториал " + usernumber + " равен " + f.fact(usernumber));
    }
}
