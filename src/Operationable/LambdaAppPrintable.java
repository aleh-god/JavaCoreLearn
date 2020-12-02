package Operationable;

//терминальные лямбды, которые не возвращают никакого значения
interface Printable{
    void print(String s);
}

public class LambdaAppPrintable {

    public static void main(String[] args) {

        Printable printer = s->System.out.println(s);
        printer.print("терминальные лямбды, которые не возвращают никакого значения");
    }
}
