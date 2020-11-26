package PaternLearn.FactoryIngrLearn;

public class TownSet implements Items{

    @Override
    public Helmet putHelmet() { return new FullHelmet(); }

    @Override
    public Armor putArmor() {
        return new PlateArmor();
    }

    @Override
    public Weapon putWeapon() {
        return new Sword();
    }
}
