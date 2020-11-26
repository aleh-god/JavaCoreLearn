package PaternLearn.FactoryIngrLearn;

public class Main {
    public static void main(String[] agrs) {
        Items itemSet;
        Heroes heroes;

        itemSet = new TownSet();
        heroes = new Warrior(itemSet);
        heroes.born();
        heroes.travel();
        heroes.fight();
        heroes.relax();
        System.out.println(heroes.toString());
    }
}
