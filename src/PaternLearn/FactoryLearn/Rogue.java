package PaternLearn.FactoryLearn;

public class Rogue extends Heroes{

    public Rogue() {
        this.name = "XXX";
        this.health = 25;
        this.alive = true;
        Characters.add("Ворует сокровища без боя.");
        Characters.add("Невидим для врагов.");
    }

    // Перегружаем стандартный метод под конкретный класс\героя
    void fight() {
        System.out.println("Герой не может сражаться.");
    }
}
