package GenericLearn;
//Кроме обобщенных типов можно также создавать обобщенные методы, которые точно также будут использовать универсальные параметры.
public class GenericMethod {

        public static void main(String[] args) {

            Printer printer = new Printer();
            String[] people = {"Tom", "Alice", "Sam", "Kate", "Bob", "Helen"};
            Integer[] numbers = {23, 4, 5, 2, 13, 456, 4};
            //При вызове подобного метода перед его именем в угловых скобках указывается, какой тип будет передаваться на место универсального параметра:
            System.out.println("String[]:");
            printer.<String>print(people);
            System.out.println("\nInteger[]:");
            printer.<Integer>print(numbers);
        }
}

    class Printer{
        //Затем внутри метода все значения типа T будут представлять данный универсальный параметр.
        public <T> void print(T[] items){
            for(T item: items){
                System.out.print(" " + item);
            }
        }
    }
