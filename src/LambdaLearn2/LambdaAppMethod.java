package LambdaLearn2;

// функциональный интерфейс
interface ExpressionMet{
    //Функциональный интерфейс Expression определяет метод isEqual(), который возвращает true, если в отношении числа n действует какое-нибудь равенство.
    //Сигнатура метода ФИ
    boolean isEqual(int n);
}
// класс, в котором определены методы
//класс ExpressionHelper не должен реализовать данный интерфейс. Его задача лишь - определить метод, который по сигнатуре (количество и тип параметров, возвращаемый тип) соответствует сигнатуре метода из функционального интерфейса
class ExpressionHelper{

    //методы, на которые идет ссылка, должны совпадать по параметрам и результату с методом функционального интерфейса.
    static boolean isEven(int n){

        //Тело метода ФИ
        return n%2 == 0;
    }

    //нестатический метод - место имени класса применяется имя объекта этого класса
    boolean isPositive(int n){

        //Тело метода ФИ
        return n > 0;
    }
}
public class LambdaAppMethod {

    public static void main(String[] args) {

        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(sum(nums, ExpressionHelper::isEven));

        //Если нам надо вызвать нестатические методы, то в ссылке вместо имени класса применяется имя объекта этого класса:
        ExpressionHelper expr = new ExpressionHelper();
        System.out.println(sum(nums, expr::isPositive));
    }

    //метод sum(), который возвращает сумму элементов массива, соответствующих некоторому условию. Условие передается в виде объекта функционального интерфейса Expression.
    private static int sum (int[] numbers, ExpressionMet func)
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