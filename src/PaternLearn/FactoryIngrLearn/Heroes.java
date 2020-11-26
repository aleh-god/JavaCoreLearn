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
        System.out.println(this.name + " путешествует.");
    }

    void fight() {
        System.out.println(this.name + " сражается.");
    }

    void relax() {
        System.out.println(this.getName() + " отдыхает.");
    }
}