package LambdaLearn2;

//Также метод в Java может возвращать лямбда-выражение
interface OperationReturn{
    //Сигнатура метода ФИ
    int execute(int x, int y);
}

public class LambdaAppOperationReturn {

    public static void main(String[] args) {

        //лямбда-выражение присваиваем ссылке на функц-интерфейс
        OperationReturn func = action(1);
        //Выполняем присвоенное лямбда-выражение
        int a = func.execute(6, 5);
        System.out.println(a);          // 11
        //можно сразу получить и тут же выполнить лямбда-выражение
        int b = action(2).execute(8, 2);
        System.out.println(b);          // 6
    }

    //Метод action принимает в качестве параметра число и в зависимости от его значения возвращает то или иное лямбда-выражение.
    //Метод статик, так как основному телу программы не надо создавать объект
    private static OperationReturn action(int number){
        switch(number){
                            //Тело метода ФИ
            case 1: return (x, y) -> x + y;
            case 2: return (x, y) -> x - y;
            case 3: return (x, y) -> x * y;
            default: return (x,y) -> 0;
        }
    }
}