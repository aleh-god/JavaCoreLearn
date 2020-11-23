package PaternLearn.FactoryLearn;

import java.util.ArrayList;

public abstract class Heroes {
    String name;
    int health;
    boolean alive;
    ArrayList<String> Characters = new ArrayList<String>();

    void prepare() {
        System.out.println("Имя героя: " + name);
        System.out.println("Здоровье равно: " + health);
        System.out.println("Статус жизни: " + alive);
        for (String i : Characters)
            System.out.println("Дополнительный навык: " + i);
    }

    void sleep() {
        System.out.println("Герой спит.");
    }

    void fight() {
        System.out.println("Герой сражается.");
    }

    void travel() {
        System.out.println("Герой путешествует.");
    }

    public String getName() {
        return name;
    }
}