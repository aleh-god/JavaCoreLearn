package GenericLearn;
// на момент написания класса мы можем точно не знать, что лучше выбрать для хранения идентификатора - строки или числа.
// Либо, возможно, этот класс будет использоваться другими разработчиками, которые могут иметь свое мнение по данной проблеме.
// Например, в качестве типа id они захотят использовать какой-то свой класс.
// Обобщения позволяют не указывать конкретный тип, который будет использоваться.

//С помощью буквы T в определении класса class Account<T> мы указываем, что данный тип T будет использоваться этим классом.
//Например ArrayList будет использовать <double> в своей коллекции.
//Параметр T в угловых скобках называется универсальным параметром, так как вместо него можно подставить любой тип
    public class Program{

        public static void main(String[] args) {

            Account2<String> acc1 = new Account2<String>("2345", 5000);
            String acc1Id = acc1.getId();
            System.out.println("ID type String: " + acc1Id);

            //работают только с объектами, но не работают с примитивными типами. То есть мы можем написать Account<Integer>,
            // но не можем использовать тип int или double, например, Account<int>.
            // Вместо примитивных типов надо использовать классы-обертки: Integer вместо int, Double вместо double и т.д.
            Account2<Integer> acc2 = new Account2<Integer>(2345, 5000);
            Integer acc2Id = acc2.getId();
            System.out.println("ID type int: " + acc2Id);
        }
    }

    class Account2<T>{

        private T id;
        private int sum;

        Account2(T id, int sum){
            this.id = id;
            this.sum = sum;
        }

        public T getId() { return id; }
        public int getSum() { return sum; }
        public void setSum(int sum) { this.sum = sum; }
    }
