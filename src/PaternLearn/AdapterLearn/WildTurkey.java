package PaternLearn.AdapterLearn;

public class WildTurkey implements Turkey {

    //Конкретная реализация обобщенного класса Turkey: как и класс Duck, она просто выводит описания своих действий.
    public void gobble() {
        System.out.println("Gobble gobble");
    }
    public void fly() {
        System.out.println("I’m flying a short distance");
    }
}