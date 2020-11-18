package Java.Animal;

public class Main {
    public static void main(String[] args) {
	// write your code here

        Cat Kitty = new Cat();
        MasterBob chyvak = new MasterBob();

        // Восходящее приведение
        Animal Pushistik = new Cat();
        //Низходящее приведение
        ((Cat)Pushistik).makeSound();

        // Анонимный класс. Меняет и расширяет методы налету, но только к текущему объекту. Для одного объекта.
        Cat dog = new Cat() {
            @Override
            public void makeSound() {
                System.out.println("Wooof");
            }
        };

        dog.makeSound();
        Kitty.makeSound();
        chyvak.takeHome();
    }
}