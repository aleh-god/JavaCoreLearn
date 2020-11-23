package PaternLearn.FactoryLearn;

public class Mage extends Heroes{

    public Mage() {
        this.name = "Gudvin";
        this.health = 50;
        this.alive = true;
        Characters.add("Может телепортироваться из боя.");
    }

    // Перегружаем стандартный метод под конкретный класс\героя
    void travel() {
        System.out.println("Маг телепортируется в новую локацию.");
    }
}