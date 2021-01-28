package Java.KlassLearn;

public class main {
        public static void main(String[] args) {

            Person tom = new Person("Tom");
            tom.display();
            Person sam = new Employee("Sam", "Oracle");
            sam.display();
        }
    }
    class Person {

        //      поле класса
        private String name;

        public String getName() { return name; }

        //              параметр
        public Person(String name){

            // this разделяет поле от параметра
            this.name=name;
        }

        public void display(){

            System.out.printf("Person %s \n", name);
        }
    }

    class Employee extends Person{

        private String company;

        public Employee(String name, String company) {

            // Делегируем выполнение в родительский класс
            super(name);
            this.company = company;
        }
        @Override
        public void display(){

            System.out.printf("Employee %s works in %s \n", super.getName(), company);
        }
    }