package PaternLearn.FactoryLearn;

public class Forest extends Dangeon{

    @Override
    protected Heroes choiseHeroes(String type) {
        if (type.equals("Воин")) {
            return new Warrior();
        } else if (type.equals("Воришка")) {
            return new Rogue();
        }
        else {
            System.out.println("Такого героя не существует!");
            return null;
        }
    }
}
