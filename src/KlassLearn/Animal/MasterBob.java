package Java.Animal;

public class MasterBob implements Human {
    int eat = 0;
    int healPoints = 100;
    MasterBob() {
        Brain mozg = new Brain();
        mozg.think();
    }
    public void takeEat() {
        this.eat +=1;
    }
    public void takeHome() {
        System.out.println("Pet, go home!");
    }
    public void takeHeal() {
        this.healPoints = 100;
    }

    // Внутренний класс. Объект может быть создан, когда создан объект мастеркласса.
    // Есть доступ к методам и атрибутам мастеркласса, но к его МиА класса нет доступа извне.
    private class Brain {
        public void think() {
            System.out.println("Im thinking");
        }
    }
}
