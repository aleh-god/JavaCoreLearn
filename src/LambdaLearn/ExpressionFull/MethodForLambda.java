package LambdaLearn.ExpressionFull;

// функциональный интерфейс
interface Expression{
    boolean isEqual(int n);
}
// класс, в котором определены методы
class ExpressionHelper{

    //Методы статик, создавать объекты не надо
    static boolean isEven(int n){

        return n%2 == 0;
    }

    static boolean isPositive(int n){

        return n > 0;
    }
}
public class MethodForLambda {

    public static void main(String[] args) {

        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        Expression expr;
        expr = (int n) -> n < 0;
        System.out.println(sum(nums, expr));

      //expr = (int n) -> n > 0;
        expr = ExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));

                                    //Expression func
        System.out.println(sum(nums, ExpressionHelper::isEven));
      //System.out.println(sum(nums, (int n) -> n%2 == 0));
    }

                                            //interface Expression
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
