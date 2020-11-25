package PaternLearn.FactoryLearn;

public class Main {
    public static void main(String[] agrs) {
        // Создаем фабрики создания героев - их здесь две.
        Dangeon factory = new Town();

        // Ссылка общая на все объекты, а сам объект создает общий метод orderHeroes по заданному параметру
        Heroes heroes = factory.orderHeroes("Воин");
        System.out.println("Создаем героя: " + heroes.getName() + " Какой он красавчик!");

        factory = new Forest();

        heroes = factory.orderHeroes("Воришка");
        System.out.println("Создаем героя: " + heroes.getName() + " Лучший всех!");
    }
}
