package LambdaLearn2;

public class LambdaAppExp {

    public static void main(String[] args) {

                        //Тело метода ФИ
        Expression func = (n)-> n%2==0;
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("сумма четных чисел = " + sum(nums, func)); // 20

        //можно не определять переменную интерфейса, а сразу передать в метод лямбда-выражение
                        //Тело метода ФИ
        int x = sum(nums, (n)-> n > 5); // сумма чисел, которые больше 5
        System.out.println("сумма чисел, которые больше 5 = " + x);  // 30
    }
    private static int sum (int[] numbers, Expression func)
    {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}
//Одним из преимуществ лямбд в java является то, что их можно передавать в качестве параметров в методы.
interface Expression{
    //Сигнатура метода ФИ
    boolean isEqual(int n);
}