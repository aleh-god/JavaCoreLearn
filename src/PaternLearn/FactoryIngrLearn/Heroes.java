package PaternLearn.FactoryIngrLearn;

public abstract class Heroes {
    String name;
    Armor armor;
    Helmet helmet;
    Weapon weapon;

    abstract void born();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Самый обычный герой";
    }

    void travel() {
        System.out.println("Герой путешествует.");
    }

    void fight() {
        System.out.println("Герой сражается.");
    }

    void relax() {
        System.out.println("Герой отдыхает.");
    }
}