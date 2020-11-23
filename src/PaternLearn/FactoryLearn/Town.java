package PaternLearn.FactoryLearn;

public class Town extends Dangeon{

    @Override
    protected Heroes choiseHeroes(String type) {
        if (type.equals("Воин")) {
            return new Warrior();
            } else if (type.equals("Маг")) {
                        return new Mage();
                        }
        else {
            System.out.println("Такого героя не существует!");
            return null;}
    }
}