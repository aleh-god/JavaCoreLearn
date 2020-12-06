package PaternLearn.ShablonLearn;

public class OldTea {

    //Каждый шаг реализован в виде отдельного метода.
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    //Каждый из этих методов реализует один шаг алгоритма:
    public void boilWater() {
        System.out.println("Boiling water");
    }
    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }
    public void addLemon() {
        System.out.println("Adding Lemon");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }

}
