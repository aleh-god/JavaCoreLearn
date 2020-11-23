package PaternLearn.FactoryLearn;

public class Main {
    public static void main(String[] agrs) {
        // Создаем фабрики создания героев - их здесь две.
        Dangeon town = new Town();
        Dangeon forest = new Forest();

        // Ссылка общая на все объекты, а сам объект создает общий метод orderHeroes по заданному параметру
        Heroes heroes = town.orderHeroes("Воин");
        System.out.println("Создаем героя: " + heroes.getName() + " Какой он красавчик!");

        heroes = forest.orderHeroes("Воришка");
        System.out.println("Создаем героя: " + heroes.getName() + " Лучший всех!");


    }
}
