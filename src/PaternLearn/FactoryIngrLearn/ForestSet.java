package PaternLearn.FactoryIngrLearn;

public class ForestSet implements Items{

    @Override
    public Helmet putHelmet() { return new Hat(); }

    @Override
    public Armor putArmor() {
        return new LightArmor();
    }

    @Override
    public Weapon putWeapon() {
        return new Bow();
    }

}