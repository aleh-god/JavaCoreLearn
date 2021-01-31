package LambdaLearn2;

//терминальные лямбды, которые не возвращают никакого значения
interface Printable{
    //Сигнатура метода ФИ
    void print(String s , boolean x);
}

public class LambdaAppPrintable {

    public static void main(String[] args) {

        //Создаме ссылку на ФИ, создавать объект не нужно
                                        // Тело метода ФИ
        Printable printer = (s , x) -> System.out.println(s + x);
        printer.print("терминальные лямбды, которые не возвращают никакого значения " , true);
    }
}
